package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Danillo
 */
public interface IDaoMembroProjeto {
    
    public Resposta<List<Usuario>> buscarUsuarios();
}
