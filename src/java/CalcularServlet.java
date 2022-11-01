/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Augusto
 */
@WebServlet(urlPatterns = {"/CalcularServlet", "/index"})
public class CalcularServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ModeloCarro = request.getParameter("ModeloCarro");
        double ValorGasolina = Double.parseDouble(request.getParameter("ValorGasolina").replaceAll( "," , "." ));
        double KMl = Double.parseDouble(request.getParameter("KMl").replaceAll( "," , "." ));
        double ValorRevisao = Double.parseDouble(request.getParameter("ValorRevisao").replaceAll( "," , "." ));
        double ValorPneus = Double.parseDouble(request.getParameter("ValorPneus").replaceAll( "," , "." ));
        
        double ValorPorKm;
        double ValorKmRevisao;
        double ValorPneusKm;
        double umKmRodado;
        double kmRodadoMais15;
        
        ValorPorKm = ValorGasolina / KMl;
        ValorKmRevisao = ValorRevisao/10000;
        ValorPneusKm = ValorPneus / 50000;
        
        umKmRodado = ValorPorKm + ValorKmRevisao + ValorPneusKm;
        
        kmRodadoMais15 = umKmRodado * 1.15;
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcularServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\" media=\"screen\">");
            out.println("<link rel=\"shortcut icon\" href=\"icon.ico\" >");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"principal\">");
            out.println("<div class=\"calculo\">");
            out.println("<h1> Calculo Km Rodado para o modelo: "+ ModeloCarro +"</h1>");
            out.println("<img src=\"images/roda.gif\" alt=\"Carro\" height=\"100px\" width=\"170px\">");
            out.println( "</div>");
            out.println( "<ul class=\"formulario\">");
            out.println("<li><h3> Valor da gasolina: "+ ValorGasolina +"</h3></li>");
            out.println("<li><h3> Media do Veiculo: "+ KMl +"</h3></li>");
            out.println("<li><h3> Revisão a cada 10mill KM: "+ ValorRevisao +"</h3></li>");
            out.println("<li><h3> Valor de 4 pneus que rodam 50 mil KM: "+ ValorPneus +"</h3></li>");
            out.println("<li><h3> Valor do Km rodado: "+ umKmRodado +"</h3></li>");
            out.println("<li><h3> Com acréscimo de 15%: "+ kmRodadoMais15 +"</h3></li>");
            out.println( "</ul>");
            out.println("<a href=\"index.html\" class=\"botaoVoltar\">Voltar</a>");
            out.println("</div>");
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
