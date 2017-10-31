/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.DAO.Login_Dao;

@WebServlet(name = "VerificarLogin", urlPatterns = {"/VerificarLogin"})
public class VerificarLogin extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nome_user = request.getParameter("login");
        String senha_user = request.getParameter("senha");
        PrintWriter out = response.getWriter(); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
            session.setAttribute("name", nome_user);
        
        
        if(Login_Dao.validate(nome_user, senha_user)){  
            RequestDispatcher rd=request.getRequestDispatcher("PainelDeControle.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("<p style=\"color:red\">Nome de usuario ou senha invalida.</p>"); 
            System.out.print(Login_Dao.validate(nome_user, senha_user));
            RequestDispatcher rd=request.getRequestDispatcher("loginpage.jsp");  
            rd.include(request,response);  
        }  

        out.close();
        
/*        if (nome_user.equals("admin") && senha_user.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("NomeUsuarioLogado", "admin");
            session.setAttribute("logado", "ok");
            
            
            RequestDispatcher resposta = request.getRequestDispatcher("PainelDeControle.jsp");
            resposta.forward(request, response);
        } else {
            RequestDispatcher resposta = request.getRequestDispatcher("loginpage.jsp");
            resposta.forward(request, response);
            //response.sendRedirect("loginpage.html");
        }
    }
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("loginpage.jsp");
    }*/

}}
