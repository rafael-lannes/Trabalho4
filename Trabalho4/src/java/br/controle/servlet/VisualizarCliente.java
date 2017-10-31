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


@WebServlet(name = "VisualizarCliente", urlPatterns = {"/VisualizarCliente"})
public class VisualizarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);
        Cliente_DAO cliente_dao = new Cliente_DAO();
        try {
            cliente_dao.get(cliente);
            request.setAttribute("Cliente", cliente);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }

}