package br.ufg.inf.fabrica.pac.negocio.imp;
 
import br.ufg.inf.fabrica.pac.negocio.IGestorMembros;
import br.ufg.inf.fabrica.pac.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.dominio.Projeto;
import br.ufg.inf.fabrica.pac.dominio.Resposta;
import br.ufg.inf.fabrica.pac.dominio.Usuario;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GestorMembrosImpl implements IGestorMembros {

    @Override
    public Resposta<List<Usuario>> buscarUsuarios(Usuario autor, Projeto projeto) {
        Resposta resposta = new Resposta();
        if(autor.isGPP())
            resposta.addItemLaudo("Usuário não possui papel de Gerente de Portifólio");
        if(projeto==null)
            resposta.addItemLaudo("Projeto não informado");
        
        List<Usuario> usuarios;
        if(resposta.isSucesso()){
            
        }
        return null;
    }

    @Override
    public Resposta<MembroProjeto> adicionarMembroProjeto(Usuario autor, MembroProjeto membro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resposta<MembroProjeto> removerMembroProjeto(Usuario autor, MembroProjeto membro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}