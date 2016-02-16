package br.ufg.inf.fabrica.pac.view.servlets.beans;


import br.ufg.inf.fabrica.pac.negocio.IGestorMembros;
import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.imp.GestorMembrosImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.ProjectStage;

public class BeanAtribuirEquipe {

    private IGestorMembros gestor;
    
    private String nome;
    
    private Usuario usuarioLogado;
    
    private Projeto projetoSelecionado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IGestorMembros getGestor() {
        return gestor;
    }

    public void setGestor(IGestorMembros gestor) {
        this.gestor = gestor;
    }

    public Usuario getUsuarioLogado() {
        return this.usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Projeto getProjetoSelecionado() {
        return this.projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }
    
    public BeanAtribuirEquipe(){
        this.nome = "Maycon";
        this.gestor = new GestorMembrosImpl();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        this.usuarioLogado = usuario;
        Projeto projeto = new Projeto();
        projeto.setId(1);
        this.projetoSelecionado = projeto;
    }
    
    public List<MembroProjeto> getMembros(){
        List<MembroProjeto> membros = new ArrayList();
        Resposta resposta;
        resposta = gestor.buscarMembros(usuarioLogado, projetoSelecionado);
        if(resposta.isSucesso()){
            membros = (List<MembroProjeto>) resposta.getValue();
        }
        return membros;
    }
    
    public List<Usuario> getNaoMembros(){
        List<Usuario> naoMembros = new ArrayList<>();
        Resposta resposta;
        resposta = gestor.buscarUsuariosNaoMembros(usuarioLogado, projetoSelecionado);
        if(resposta.isSucesso()){
            naoMembros = (List<Usuario>) resposta.getValue();
        }
        return naoMembros;
    } 
}
