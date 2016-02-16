package br.ufg.inf.fabrica.pac.negocio.imp;
 
import br.ufg.inf.fabrica.pac.negocio.IGestorMembros;
import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.persistencia.IDaoMembroProjeto;
import br.ufg.inf.fabrica.pac.persistencia.imp.DaoMembroProjetoImpl;
import br.ufg.inf.fabrica.pac.persistencia.imp.DaoUsuario;
import java.util.ArrayList;
import java.util.List;


public class GestorMembrosImpl implements IGestorMembros {

    @Override
    public Resposta<MembroProjeto> adicionarMembroProjeto(Usuario autor, MembroProjeto membro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<MembroProjeto> removerMembroProjeto(Usuario autor, MembroProjeto membro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<List<Usuario>> buscarUsuariosNaoMembros(Usuario autor, Projeto projeto) {
        Resposta<List<Usuario>> resposta = new Resposta();
        if(!autor.isGPP())
            resposta.addItemLaudo("Usuário não possui papel de Gerente de Portifólio");
        if(projeto==null)
            resposta.addItemLaudo("Projeto não informado");
        IDaoMembroProjeto dao = new DaoMembroProjetoImpl();
        List<Usuario> usuarios = dao.buscarUsuariosNaoMembrosPorProjeto(projeto.getId()).getValue();
        resposta.setValue(usuarios);
        return resposta;
    }

    @Override
    public Resposta<List<MembroProjeto>> buscarMembros(Usuario autor, Projeto projeto) {
        Resposta<List<MembroProjeto>> resposta = new Resposta();
        if(!autor.isGPP())
            resposta.addItemLaudo("Usuário não possui papel de Gerente de Portifólio");
        if(projeto==null)
            resposta.addItemLaudo("Projeto não informado");
        IDaoMembroProjeto dao = new DaoMembroProjetoImpl();
        List<MembroProjeto> membros = dao.buscarMembrosPorProjeto(projeto.getId()).getValue();
        resposta.setValue(membros);
        return resposta;
    }
    
}