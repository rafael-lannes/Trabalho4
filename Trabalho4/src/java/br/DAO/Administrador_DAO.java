package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */

public class Administrador_DAO {

    public void Inserir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ADMINISTRADOR (id,login,senha) VALUES (?,?,?)");
            sql.setInt(1,administrador.getId());
            sql.setString(2, administrador.getLogin());
            sql.setString(3, administrador.getSenha());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador get(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    administrador.setLogin(resultado.getString("LOGIN"));
                    administrador.setSenha(resultado.getString("SENHA"));
                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE ADMINISTRADOR SET Login = ?, Senha = ?  WHERE ID = ? ");
            sql.setString(1, adm.getLogin());
            sql.setString(2, adm.getSenha());
            sql.setInt(3, adm.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Administrador adm) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, adm.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Administrador> Listar() {
        ArrayList<Administrador> meusAdms = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador adm;
                    adm = new Administrador(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("LOGIN"),
                            resultado.getString("SENHA"));
                    meusAdms.add(adm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusAdms;

    }

}

