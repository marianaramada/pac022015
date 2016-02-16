package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Danillo
 */
public interface IDaoMembroProjeto {
    
    /**
     * Retorna todos os usuários com seus respectivos papéis
     * @param idProjeto
     * @return 
     */
    public Resposta<List<Usuario>> buscarUsuariosNaoMembrosPorProjeto(long idProjeto);
    
    public Resposta<List<MembroProjeto>> buscarMembrosPorProjeto(long idProjeto);
}
