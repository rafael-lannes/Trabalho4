package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */

public class Cliente_DAO {

    public void Inserir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTES (id,nome,endereço,bairro,cidade,cep,estado,REFERÊNCIA,cpf,rg,telfixo,celular,cartao,bandeira) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setInt(1,cliente.getId());
            sql.setString(2, cliente.getNome());
            sql.setString(3, cliente.getEndereco());
            sql.setString(4, cliente.getBairro());
            sql.setString(5, cliente.getCidade());
            sql.setLong(6, cliente.getCEP());
            sql.setString(7,cliente.getEstado());
            sql.setString(8, cliente.getReferencia());
            sql.setLong(9, cliente.getCPF());
            sql.setLong(10, cliente.getRG());
            sql.setLong(11, cliente.getTel());
            sql.setLong(12, cliente.getCel());
            sql.setLong(13, cliente.getCartao());
            sql.setString(14, cliente.getBandeira());
            sql.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente get(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, cliente.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setEndereço(resultado.getString("endereço"));
                    cliente.setBairro(resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));
                    cliente.setCEP(resultado.getLong("CEP"));
                    cliente.setEstado(resultado.getString("estado"));
                    cliente.setReferencia(resultado.getString("referência"));
                    cliente.setCPF(resultado.getLong("CPF"));
                    cliente.setRG(resultado.getLong("RG"));
                    cliente.setTel(resultado.getLong("telfixo"));
                    cliente.setCel(resultado.getLong("celular"));
                    cliente.setCartao(resultado.getLong("cartao"));
                    cliente.setBandeira(resultado.getString("bandeira"));  
                }
            }
            return cliente;

        } catch (Exception e) {
            System.out.print("Erro no getCliente()"+e);
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTES SET nome=?,endereço=?,bairro=?,cidade=?,cep=?,estado=?,REFERÊNCIA=?,cpf=?,rg=?,telfixo=?,celular=?,cartao=?,bandeira=? WHERE ID=?");
            sql.setString(1, cliente.getNome());
            sql.setString(2, cliente.getEndereco());
            sql.setString(3, cliente.getBairro());
            sql.setString(4, cliente.getCidade());
            sql.setLong(5, cliente.getCEP());
            sql.setString(6,cliente.getEstado());
            sql.setString(7, cliente.getReferencia());
            sql.setLong(8, cliente.getCPF());
            sql.setLong(9, cliente.getRG());
            sql.setLong(10, cliente.getTel());
            sql.setLong(11, cliente.getCel());
            sql.setLong(12, cliente.getCartao());
            sql.setString(13, cliente.getBandeira());
            sql.setInt(14, cliente.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            System.out.print("Erro no Cliente.Alterar()"+e);
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, cliente.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> meusClientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTES";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Cliente cliente;
                    cliente = new Cliente(resultado.getInt("id"),
                            resultado.getString("nome"),
                            resultado.getString("endereço"),
                            resultado.getString("bairro"),
                            resultado.getString("cidade"),
                            resultado.getLong("CEP"),
                            resultado.getString("Estado"),
                            resultado.getString("Referência"),
                            resultado.getLong("CPF"),
                            resultado.getLong("RG"),
                            resultado.getLong("TELFIXO"),
                            resultado.getLong("CELULAR"),
                            resultado.getLong("Cartao"),
                            resultado.getString("Bandeira"));
                    meusClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusClientes;

    }

}