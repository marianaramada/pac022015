package br.ufg.inf.fabrica.pac.negocio.dominio;

/**
 *
 * @author danilloguimaraes
 */
public class Usuario {

    //Id não é gerado automaticamente, ele é gerado pelo ldap
    private long id;
    private boolean ativo;

    //Transient
    private String login;
    private String senha;
    private String nome;
    private String email;

    public Usuario() {

    }

    public Usuario(String login, String nome, String email) {
        this.login = login;
        this.nome = nome;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean value) {
        this.ativo = value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
