/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class tablas extends HttpServlet {


	int j;
	int numero1=1;
	int numero2=2;
	int numero3=3;
	int numero4=4;
	int numero5=5;
	int numero6=6;
	int numero7=7;
	int numero8=8;
	int numero9=9;
	int numero10=10;
	

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tablas de multiplicar</title>");            
            out.println("</head>");
            out.println("<body style=background-color:#0000ff;>");
			
            out.println("<h1>Tablas de multiplicar del 1 al 10</h1>");
			out.println("<br>");
			
			out.println("<h2>Tabla del 1</h2>");//tabla del 1
			for(j = 1; j <= 10; j++)
            {
                out.println(numero1 + " X " + j + " = " + numero1*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 2</h2>");//2
			for(j = 1; j <= 10; j++)
            {
                out.println(numero2 + " X " + j + " = " + numero2*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 3</h2>");//3
			for(j = 1; j <= 10; j++)
            {
                out.println(numero3 + " X " + j + " = " + numero3*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 4</h2>");//4
			for(j = 1; j <= 10; j++)
            {
                out.println(numero4 + " X " + j + " = " + numero4*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 5</h2>");//5
			for(j = 1; j <= 10; j++)
            {
                out.println(numero5 + " X " + j + " = " + numero5*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 6</h2>");//6
			for(j = 1; j <= 10; j++)
            {
                out.println(numero6 + " X " + j + " = " + numero6*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 7</h2>");//7
			for(j = 1; j <= 10; j++)
            {
                out.println(numero7 + " X " + j + " = " + numero7*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 8</h2>");//8
			for(j = 1; j <= 10; j++)
            {
                out.println(numero8 + " X " + j + " = " + numero8*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 9</h2>");//9
			for(j = 1; j <= 10; j++)
            {
                out.println(numero9 + " X " + j + " = " + numero9*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
			out.println("<h2>Tabla del 10</h2>");//10
			for(j = 1; j <= 10; j++)
            {
                out.println(numero10 + " X " + j + " = " + numero10*j);
				out.println("<br/>");
            }
            out.println("<br>");
			
            out.println("</body>");
            out.println("</html>");
        }
				
    }

    
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
    }

}
