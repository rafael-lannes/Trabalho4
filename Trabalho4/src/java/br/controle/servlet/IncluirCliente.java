package br.controle.servlet;


import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCliente", urlPatterns = {"/IncluirCliente"})
public class IncluirCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        long cep = Long.parseLong(request.getParameter("cep"));        
        String estado = request.getParameter("estado");
        String referencia = request.getParameter("referencia");        
        long cpf = Long.parseLong(request.getParameter("cpf"));
        long rg = Long.parseLong(request.getParameter("rg"));        
        long tel = Long.parseLong(request.getParameter("tel"));
        long cel = Long.parseLong(request.getParameter("cel"));
        long cartao = Long.parseLong(request.getParameter("credito")); 
        String bandeira = request.getParameter("bandeira"); 
          
        Cliente cliente = new Cliente(id,nome,endereco,bairro,cidade,cep,estado,referencia,cpf,rg,tel,cel,cartao,bandeira);
        Cliente_DAO cliente_dao = new Cliente_DAO();
        try{
            cliente_dao.Inserir(cliente);
            RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
            rd.forward(request, response);
        }
        catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                    rd.forward(request, response);
                }
            
        }


}