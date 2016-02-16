package br.ufg.inf.fabrica.pac.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <Chave>
 */
public class Resposta <Chave> {
    private Chave value;
    private final List<String> laudo = new ArrayList<>();
    private boolean sucesso = true;
    
    public Chave getValue() {
        return value;
    }

    public void setValue(Chave value) {
        this.value = value;
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
}