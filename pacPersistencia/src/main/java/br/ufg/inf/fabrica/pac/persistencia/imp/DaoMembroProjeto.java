/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.pac.persistencia.imp;

import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Projeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.persistencia.IDaoMembroProjeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author auf
 */
public class DaoMembroProjeto implements IDaoMembroProjeto {

    @Override
    public MembroProjeto salvar(MembroProjeto entity) {
        return null;
    }

    @Override
    public MembroProjeto excluir(MembroProjeto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MembroProjeto buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<MembroProjeto> buscar(Projeto projeto, String papel) {
        String sql = "select * from MEMBRO_PROJETO where idProjeto=?, papel=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, projeto.getId());
            pst.setString(2, papel);
            ResultSet rs = pst.executeQuery();
            List<MembroProjeto> membroProjeto = new ArrayList<>();
            MembroProjeto mP = null;

            while (rs.next()) {
                mP = new MembroProjeto();
                mP.setIdProjeto(rs.getLong("idProjeto"));
                mP.setIdUsuario(rs.getLong("idUsuario"));
                mP.setPapel(rs.getString("papel"));
                membroProjeto.add(mP);
            }
            return membroProjeto;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPacote.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<MembroProjeto> buscar(Projeto projeto, Usuario usuario) {
        String sql = "select * from MEMBRO_PROJETO where idProjeto=? and idUsuario=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setLong(1, projeto.getId());
            pst.setLong(2, usuario.getId());
            ResultSet rs = pst.executeQuery();
            List<MembroProjeto> membroProjeto = new ArrayList<>();
            MembroProjeto mP = null;

            while (rs.next()) {
                mP = new MembroProjeto();
                mP.setIdProjeto(rs.getLong("idProjeto"));
                mP.setIdUsuario(rs.getLong("idUsuario"));
                mP.setPapel(rs.getString("papel"));
                membroProjeto.add(mP);
            }
            return membroProjeto;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPacote.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<MembroProjeto> buscar(String papel, Usuario usuario) {
        String sql = "select * from MEMBRO_PROJETO where papel=?, idUsuario=?";
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql);
            pst.setString(1, papel);
            pst.setLong(2, usuario.getId());
            ResultSet rs = pst.executeQuery();
            List<MembroProjeto> membroProjeto = new ArrayList<>();
            MembroProjeto mP = null;

            while (rs.next()) {
                mP = new MembroProjeto();
                mP.setIdProjeto(rs.getLong("idProjeto"));
                mP.setIdUsuario(rs.getLong("idUsuario"));
                mP.setPapel(rs.getString("papel"));
                membroProjeto.add(mP);
            }
            return membroProjeto;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPacote.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
