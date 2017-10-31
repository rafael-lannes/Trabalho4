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


@WebServlet(name = "ExcluirCliente", urlPatterns = {"/ExcluirCliente"})
public class ExcluirCliente extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);
        Cliente_DAO cliente_dao = new Cliente_DAO();
        try {
            cliente_dao.get(cliente);
            request.setAttribute("Cliente", cliente);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            request.setAttribute("erro", e);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Cliente cliente = new Cliente(id);
        try {
                Cliente_DAO cliente_dao = new Cliente_DAO();
                try {
                    cliente_dao.Excluir(cliente);
                    //request.setAttribute("mensagem", "Exclusão Com Sucesso");
                    //request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }

    }
}
