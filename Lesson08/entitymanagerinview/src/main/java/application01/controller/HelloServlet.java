package application01.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = { "/", "/Hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setAttribute("now", new Date());
//		request.setAttribute("one", 1);
//		request.setAttribute("two", 2);

//		ServletContext context = this.getServletContext();
//		String jsp = "/Hello.jsp";
//		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
//		dispatcher.forward(request, response);

//		request.getRequestDispatcher("Hello.jsp").forward(request, response);

		request.getRequestDispatcher("customerForm.jsp").forward(request, response);
	}
}
