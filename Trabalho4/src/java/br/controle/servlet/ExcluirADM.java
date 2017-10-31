package br.controle.servlet;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ExcluirADM", urlPatterns = {"/ExcluirADM"})
public class ExcluirADM extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador adm = new Administrador(id);
        Administrador_DAO adm_dao = new Administrador_DAO();
        try {
            adm_dao.get(adm);
            request.setAttribute("adm", adm);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Adm_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Administrador adm = new Administrador(id);
        try {
                Administrador_DAO adm_dao = new Administrador_DAO();
                try {
                    adm_dao.Excluir(adm);
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

