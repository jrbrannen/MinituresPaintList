package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paint;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = "/viewAllPaintsServlet";

		PaintHelper ph = new PaintHelper();

		String act = request.getParameter("doThisToItem");

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Paint paintToDelete = ph.searchForPaintById(tempId);
				ph.deletePaint(paintToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item.");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Paint paintToEdit = ph.searchForPaintById(tempId);
				request.setAttribute("paintToEdit", paintToEdit);
				path = "/edit-paint.jsp";		
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item.");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
