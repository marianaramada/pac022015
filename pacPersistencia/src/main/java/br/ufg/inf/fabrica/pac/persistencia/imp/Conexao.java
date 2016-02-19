package br.ufg.inf.fabrica.pac.persistencia.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danillo
 */
public class Conexao {
    public static Connection getConnection() throws SQLException{
        return Conexao.getConnection(false);
    }
    
    public static Connection getConnection(boolean controleTransacao) throws SQLException{
        String dbUrl = "jdbc:derby://localhost:1527/pac2015";
        String user  = "pac";
        String senha = "pac";
        Connection con = DriverManager.getConnection(dbUrl, user, senha);
        con.setAutoCommit(!controleTransacao);
        return con;
    }
}