package br.ufg.inf.fabrica.pac.persistencia;

import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danillo
 */
public interface IDaoMembroProjeto {
    
    /**
     *
     * @param idProjeto
     * @param usuarioPesquisado
     * @return
     */
    public Resposta<List<Usuario>> buscarUsuariosNaoMembrosPorProjeto(long idProjeto, String usuarioPesquisado);
    
    public Resposta<List<MembroProjeto>> buscarMembrosPorProjeto(long idProjeto);

    public List<MembroProjeto> adicionarMembrosProjeto(List<MembroProjeto> membros) throws SQLException;
}
