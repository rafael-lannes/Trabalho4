package br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    String url = "jdbc:derby://localhost:1527/";
    String dbName = "trabalho4";
    String driver = "org.apache.derby.jdbc.ClientDriver";
    String userName = "root";
    String password = "12345";
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName(driver).newInstance();
            conexao = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
    
    public void closeConexao(){
        try {
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

 
}