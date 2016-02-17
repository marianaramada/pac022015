package br.ufg.inf.fabrica.pac.persistencia.imp;

import br.ufg.inf.fabrica.pac.negocio.dominio.Estado;
import br.ufg.inf.fabrica.pac.persistencia.IDaoEstado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danillo
 */
public class DaoEstado implements IDaoEstado {

    @Override
    public Estado salvar(Estado entity) {

        String sqlUpdate = "update ESTADO set nome=?, descricao=?, estadoFinal=? where id=?";
        String sqlInsert = "insert into ESTADO (nome, descricao, estadoFinal) values (?, ?, ?)";
        try {
            PreparedStatement pst;
            if (entity.getId() == 0) {
                pst = Conexao.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            } else {
                pst = Conexao.getConnection().prepareStatement(sqlUpdate);
                pst.setLong(4, entity.getId());
            }

            pst.setString(1, entity.getNome());
            pst.setString(2, entity.getDescricao());
            pst.setBoolean(3, entity.isEstadoFinal());
            pst.execute();
            if (entity.getId() == 0) {
                ResultSet keys = pst.getGeneratedKeys();
                if (keys.next()) {
                    entity.setId(keys.getInt(1));
                }
            }
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Estado excluir(Estado entity) {
        String sql = "delete from ESTADO where id=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, entity.getId());
            pst.execute();
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Estado buscar(long id) {
        String sql = "select E.* from ESTADO as E where id=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            Estado estado = null;
            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getLong("id"));
                estado.setDescricao(rs.getString("descricao"));
                estado.setEstadoFinal(rs.getBoolean("estadoFinal"));
                estado.setNome(rs.getString("nome"));
            }
            return estado;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Estado buscarPorNome(String nome) {
        String sql = "select E.* from ESTADO as E where nome = ?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            Estado estado = null;
            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getLong("id"));
                estado.setDescricao(rs.getString("descricao"));
                estado.setEstadoFinal(rs.getBoolean("estadoFinal"));
                estado.setNome(rs.getString("nome"));
            }
            return estado;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
