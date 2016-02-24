<<<<<<< HEAD:pacDominio/src/main/java/br/ufg/inf/fabrica/pac/dominio/Resposta.java
package br.ufg.inf.fabrica.pac.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <Chave>
 */
public class Resposta <Chave> {
    private Chave chave;
    private final List<String> laudo = new ArrayList<>();
    private boolean sucesso = true;
    
    public Chave getChave() {
        return chave;
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }

    public List<String> getLaudo() {
        return laudo;
    }
    
    public void addItemLaudo(String item){
        this.laudo.add(item);
        this.sucesso = false;
    }
    
    public boolean isSucesso(){
        return this.sucesso;
    }
=======
package br.ufg.inf.fabrica.pac.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <Chave>
 */
public class Resposta <Chave> {
    private Chave chave;
    private final List<String> laudo = new ArrayList<>();
    private boolean sucesso = true;
    
    public Chave getChave() {
        return chave;
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }

    public List<String> getLaudo() {
        return laudo;
    }
    
    public void addItemLaudo(String item){
        this.laudo.add(item);
        this.sucesso = false;
    }
    
    public boolean isSucesso(){
        return this.sucesso;
    }
>>>>>>> d77ba0f622a74685e9519f29068bd70b23c771f4:pacDominio/src/main/java/br/ufg/inf/fabrica/pac/dominio/Resposta.java
}