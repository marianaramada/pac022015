package br.ufg.inf.fabrica.pac.persistencia.imp;

import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.persistencia.IDaoMembroProjeto;
import java.util.List;


public class DaoMembroProjetoImpl implements IDaoMembroProjeto {

    @Override
    public Resposta<List<Usuario>> buscarUsuarios() {
        String sql = "select U.*, M.* from USUARIO U left join MEMBRO_PROJETO M on U.ID = M.ID_USUARIO order by U.ID";
        return null;
    }
    
}
