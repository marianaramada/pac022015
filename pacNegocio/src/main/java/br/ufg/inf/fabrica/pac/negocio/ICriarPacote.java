/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.pac.negocio;

import br.ufg.inf.fabrica.pac.negocio.dominio.Pacote;
import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;

/**
 *
 * @author auf
 */
public interface ICriarPacote {

    public Resposta<Pacote> criarPacote(Pacote pacote, Usuario usuarioLogado, Projeto projetoSelecionado);

}
