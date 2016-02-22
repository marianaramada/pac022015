package br.ufg.inf.fabrica.pac.persistencia.imp;

import br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto;
import br.ufg.inf.fabrica.pac.negocio.dominio.Resposta;
import br.ufg.inf.fabrica.pac.negocio.dominio.Usuario;
import br.ufg.inf.fabrica.pac.persistencia.IDaoMembroProjeto;
import br.ufg.inf.fabrica.pac.persistencia.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMembroProjetoImpl implements IDaoMembroProjeto {

    public Resposta<List<Usuario>> buscarUsuarios() {
        StringBuilder sb = new StringBuilder();
        sb.append("select U.*, M.* from USUARIO U ").
                append("left join MEMBRO_PROJETO M on U.ID = M.IDUSUARIO ").
                append("order by U.ID");
        Resposta resposta = new Resposta();
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sb.toString());
            ResultSet rs = pst.executeQuery();
            List<Usuario> usuarios = new ArrayList();
            while (rs.next()) {
                Usuario usuario = Util.populaObjeto(Usuario.class, rs);
                MembroProjeto membro = Util.populaObjeto(MembroProjeto.class,
                        rs);
                if (membro.getIdUsuario() > 0) {
                    membro.setUsuario(usuario);
                }
                usuarios.add(usuario);
            }
            resposta.setValue(usuarios);
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null,
                    ex);
            resposta.setValue(null);
            resposta.addItemLaudo(ex.getMessage());
        }
        return resposta;
    }

    public static void main(String[] args) {
        DaoMembroProjetoImpl dao = new DaoMembroProjetoImpl();
        dao.buscarUsuarios();
    }

    @Override
    public Resposta<List<Usuario>> buscarUsuariosNaoMembrosPorProjeto(
            long idProjeto, String usuarioPesquisado) {
        StringBuilder sql = new StringBuilder();
        sql.append("select u.* from Usuario u ").
                append("where u.nome like ? and u.id not in ").
                append("(select m.idUsuario from Membro_Projeto m ").
                append("where m.idProjeto = ?)");
        Resposta resposta = new Resposta();
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql.toString());
            pst.setString(1, usuarioPesquisado + "%");
            pst.setLong(2, idProjeto);
            ResultSet rs = pst.executeQuery();
            List<Usuario> usuarios = new ArrayList();
            while (rs.next()) {
                Usuario usuario = Util.populaObjeto(Usuario.class, rs);
                usuarios.add(usuario);
            }
            resposta.setValue(usuarios);
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null,
                    ex);
            resposta.setValue(null);
            resposta.addItemLaudo(ex.getMessage());
        }
        return resposta;
    }

    @Override
    public Resposta<List<MembroProjeto>> buscarMembrosPorProjeto(long idProjeto) {
        StringBuilder sql = new StringBuilder();
        sql.append("select m.*, u.* from MEMBRO_PROJETO m ").
                append("inner join USUARIO u ").
                append("on m.IDUSUARIO=u.ID ").
                append("where m.IDPROJETO = ? ORDER by m.IDUSUARIO");

        Resposta resposta = new Resposta();
        try {
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql.toString());
            pst.setLong(1, idProjeto);
            ResultSet rs = pst.executeQuery();
            List<MembroProjeto> membros = new ArrayList();
            while (rs.next()) {
                Usuario usuario = Util.populaObjeto(Usuario.class, rs);
                MembroProjeto membro = Util.populaObjeto(MembroProjeto.class,
                        rs);
                membro.setUsuario(usuario);
                membros.add(membro);
            }
            resposta.setValue(membros);
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null,
                    ex);
            resposta.setValue(null);
            resposta.addItemLaudo(ex.getMessage());
        }
        return resposta;
    }

    @Override
    public List<MembroProjeto> adicionarMembrosProjeto(
            List<MembroProjeto> membros) throws SQLException {
        Connection con = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into MEMBRO_PROJETO ").
                    append("(IDUSUARIO, IDPROJETO, PAPEL) ").
                    append("values (?, ?, ?)");

            con = Conexao.getConnection();
            PreparedStatement pst;
            pst = Conexao.getConnection().prepareStatement(sql.toString());
            for (MembroProjeto membro : membros) {
                pst.setLong(1, membro.getIdUsuario());
                pst.setLong(2, membro.getIdProjeto());
                pst.setString(3, membro.getPapel());
                pst.execute();
            }
            con.commit();
        } finally {
            if (!con.isClosed()) {
                con.close();
            }
        }
        return null;
    }

    @Override
    public void atualizarPapeisDeUsuarioEmUmProjeto(
            List<MembroProjeto> papeisRemovidos,
            List<MembroProjeto> papeisAdicionados) throws SQLException {
        StringBuilder sqlInsercao = new StringBuilder();
        StringBuilder sqlDelecao = new StringBuilder();
        sqlInsercao.append("insert into MEMBRO_PROJETO").
                append(" (IDUSUARIO, IDPROJETO, PAPEL) ").
                append(" VALUES (?,?,?)");
        sqlDelecao.append("delete from MEMBRO_PROJETO ").
                append("where IDUSUARIO = ? and ").
                append("IDPROJETO = ? and ").
                append("PAPEL like ? ");

        Connection con = null;
        try {
            con = Conexao.getConnection(true);

            PreparedStatement pstmt;
            for (MembroProjeto papelAdicionado : papeisAdicionados) {
                pstmt = con.prepareStatement(sqlInsercao.toString());
                pstmt.setLong(1, papelAdicionado.getIdUsuario());
                pstmt.setLong(2, papelAdicionado.getIdProjeto());
                pstmt.setString(3, papelAdicionado.getPapel());
                pstmt.execute();
            }
            for (MembroProjeto papelRemovido : papeisRemovidos) {
                pstmt = con.prepareStatement(sqlDelecao.toString());
                pstmt.setLong(1, papelRemovido.getIdUsuario());
                pstmt.setLong(2, papelRemovido.getIdProjeto());
                pstmt.setString(3, papelRemovido.getPapel());
                pstmt.execute();
            }

            con.commit();
        } finally {
            if (!con.isClosed()) {
                con.close();
            }
        }
    }

}
