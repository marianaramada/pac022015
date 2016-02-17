package br.ufg.inf.fabrica.pac.negocio.imp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ufg.inf.fabrica.pac.negocio.ICriarPacote;
import br.ufg.inf.fabrica.pac.negocio.dominio.Estado;
import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Pacote;
import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.utils.Utils;
import br.ufg.inf.fabrica.pac.persistencia.imp.DaoEstado;
import br.ufg.inf.fabrica.pac.persistencia.imp.DaoMembroProjeto;
import br.ufg.inf.fabrica.pac.persistencia.imp.DaoPacote;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author auf
 */
public class CriarPacote implements ICriarPacote {

    @Override
    public Resposta<Pacote> criarPacote(Pacote pacote, Usuario usuarioLogado, Projeto projetoSelecionado) {
        Resposta<Pacote> resp = new Resposta<Pacote>();
        //Verificar se o usuario pertence ao projeto e neste tem o perfil GPR .
        List<MembroProjeto> membroProjeto;
        membroProjeto = DaoMembroProjeto.buscar(projetoSelecionado, usuarioLogado);

        if (membroProjeto != null && membroProjeto.size() > 0) {
            for (MembroProjeto mP : membroProjeto) {
                if (!(mP.getPapel().equals("GPR") || mP.getIdProjeto() == projetoSelecionado.getId())) {
                    resp.setChave(null);
                    resp.addItemLaudo("Usuario logado não possui permissão para criar pacotes nesse projeto!");
                    return resp;
                }
            }
        } else {
            resp.setChave(null);
            resp.addItemLaudo("Usuario logado não possui permissão para criar pacotes nesse projeto!");
            return resp;
        }
        Date hoje = new Date();
        hoje.setHours(0);
        hoje.setMinutes(0);
        hoje.setSeconds(0);
        hoje.setTime(0);
        if (pacoteTemCampoVazio(pacote)) {
            resp.setChave(null);
            resp.addItemLaudo("Pacote com campos vazios!");
            return resp;
        }
        if (pacote.getDataPrevistaRealizacao().compareTo(hoje) < 0) {
            resp.setChave(null);
            resp.addItemLaudo("Data Prevista Realização deve ser maior ou igual a data atual!");
            return resp;
        }

        pacote.setAbandonado(false);
        pacote.setDataCriacao(hoje);
        pacote.setIdProjeto(projetoSelecionado.getId());

        Estado estado = DaoEstado.buscarPorNome("novo");
        pacote.setIdEstado(estado.getId());
        pacote.setIdUsuario(usuarioLogado.getId());
        DaoPacote pacoteDao = new DaoPacote();
        try {
            pacoteDao.salvar(pacote);
            resp.setChave(pacote);
            resp.addItemLaudo("Pacote criado com sucesso!");
            return resp;
        } catch (Exception ex) {
            Logger.getLogger(DaoPacote.class.getName()).log(Level.SEVERE, null, ex);
            resp.setChave(null);
            resp.addItemLaudo("Erro de Sistema: Pacote não podê ser criado no banco!");
            return resp;
        }
    }

    public boolean pacoteTemCampoVazio(Pacote pacote) {
        if (Utils.stringVaziaOuNula(pacote.getNome()) || Utils.stringVaziaOuNula(pacote.getDescricao())
                || Utils.stringVaziaOuNula(pacote.getDocumento())) {
            return true;
        }
        return false;
    }

}
