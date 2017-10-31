package br.controle.servlet;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "EditarADM", urlPatterns = {"/EditarADM"})
public class EditarADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Administrador adm = new Administrador(id,login,senha);
        Administrador_DAO adm_dao = new Administrador_DAO();
        try {
            adm_dao.get(adm);
            request.setAttribute("adm", adm);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Adm_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Administrador adm = new Administrador(id, login, senha);
        try {
            if ((login.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (login.isEmpty()) {
                    request.setAttribute("erro_nome", "O login não pode ser vazio");
                }

                request.setAttribute("adm", adm);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Adm_Editar.jsp");
                rd.forward(request, response);
            } else {

                Administrador_DAO adm_dao = new Administrador_DAO();
                try {
                    adm_dao.Alterar(adm);
                    //request.setAttribute("mensagem", "Alterado Com Sucesso");
                    //request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O login não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("IncluirAdm.jsp");
            rd.forward(request, response);
        }

    }

}
