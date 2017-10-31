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

@WebServlet(name = "IncluirADM", urlPatterns = {"/IncluirADM"})
public class IncluirAdm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Administrador adm = new Administrador(id,login,senha);
        Administrador_DAO adm_dao = new Administrador_DAO();
        try{
            adm_dao.Inserir(adm);
            //request.setAttribute("mensagem", "Inclusão Com Sucesso");
            //request.setAttribute("retorna", "ListaContato");
            RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
            rd.forward(request, response);
        }
        catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                    rd.forward(request, response);
                }
            
        }


}

