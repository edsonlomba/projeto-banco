/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoweb;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import bancodao.Titular;
import bancodao.TitularDaoInterface;
import bancodao.TitularDaoRelacional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41525388
 */
public class ListarTitularServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConexaoInterface conexao = new ConexaoJavaDb("localhost",1527,"app","app","sistema_bancario");
        boolean conexaoEstabelecida = false;
        TitularDaoInterface dao = null;
        try {
            dao = new TitularDaoRelacional(conexao);
            conexaoEstabelecida = true;
        } catch (ConexaoException e) {
            conexaoEstabelecida = false; 
        } catch (BancoDaoException ex) {
            conexaoEstabelecida = false;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Titulares</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listar todos os titulares</h1>");
            if (conexaoEstabelecida) {
                List<Titular> titulares;
                try {
                    titulares = dao.obterTodos();
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>Número</th><th>Nome</th><th>RG</th><th>CPF</th>");
                    out.println("</tr>");
                    for(Titular t: titulares){
                        out.println("<tr>");
                        out.println("<td>" + t.getNumero() + "</td>");
                        out.println("<td>" + t.getNome() + "</td>");
                        out.println("<td>" + t.getRg() + "</td>");
                        out.println("<td>" + t.getCpf() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } catch (BancoDaoException ex) {
                    out.println("<p>Erro na operação!</p>");
                }
            }
            else{
               out.println("<p>Infelizmente o sistema está fora do ar!</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
