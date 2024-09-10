package vn.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home","/trangchu"})
public class HomeController extends HttpServlet {

	
	private static final long serialVersionUID = -3176435550632993070L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String name1 = req.getParameter("ten");
		String name2 = req.getParameter("ho");
		
		req.setAttribute("fname", name1);
       req.setAttribute("lname", name2);
		
		PrintWriter printW = resp.getWriter();
		printW.println("<h1>${name1}-${name2}</h1>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/Home.html");
        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	String name1 = req.getParameter("ten");
		String name2 = req.getParameter("ho");
		
	req.setAttribute("fname", name1);
        req.setAttribute("lname", name2);
		
		PrintWriter printW = resp.getWriter();
		printW.println(name2 + " "+ name1);

		RequestDispatcher rd = req.getRequestDispatcher("/views/Home.html");
       rd.include(req, resp);
	}
	
	
}
