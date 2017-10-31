package br.controle.servlet;

import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        //String nome = request.getParameter("nome");
        //String endereco = request.getParameter("endereco");
        //String bairro = request.getParameter("bairro");
        //String cidade = request.getParameter("cidade");
        //long cep = Long.parseLong(request.getParameter("CEP"));        
        //String estado = request.getParameter("estado");
        //String referencia = request.getParameter("referencia");        
        //long cpf = Long.parseLong(request.getParameter("cpf"));
        //long rg = Long.parseLong(request.getParameter("rg"));        
        //long tel = Long.parseLong(request.getParameter("tel"));
        //long cel = Long.parseLong(request.getParameter("cel"));
        //long cartao = Long.parseLong(request.getParameter("credito")); 
        //String bandeira = request.getParameter("bandeira"); 
        
        //System.out.print("Recebido:"+id+nome+endereco+bairro+cidade+cep+estado+referencia+cpf+rg+tel+cel+cartao+bandeira);
        Cliente cliente = new Cliente(id);
        Cliente_DAO cliente_dao = new Cliente_DAO();
        try {
            cliente_dao.get(cliente);
            request.setAttribute("Cliente", cliente);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        long cep = Long.parseLong(request.getParameter("CEP"));        
        String estado = request.getParameter("estado");
        String referencia = request.getParameter("referencia");        
        long cpf = Long.parseLong(request.getParameter("cpf"));
        long rg = Long.parseLong(request.getParameter("rg"));        
        long tel = Long.parseLong(request.getParameter("tel"));
        long cel = Long.parseLong(request.getParameter("cel"));
        long cartao = Long.parseLong(request.getParameter("credito")); 
        String bandeira = request.getParameter("bandeira"); 

        Cliente cliente = new Cliente(id,nome,endereco,bairro,cidade,cep,estado,referencia,cpf,rg,tel,cel,cartao,bandeira);
        try {
            if ((nome.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                request.setAttribute("Cliente", cliente);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Editar.jsp");
                rd.forward(request, response);
            } else {

                Cliente_DAO cliente_dao = new Cliente_DAO();
                try {
                    cliente_dao.Alterar(cliente);
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
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("IncluirCliente.jsp");
            rd.forward(request, response);
        }

    }

}
