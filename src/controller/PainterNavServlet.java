package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paint;
import model.Painter;

/**
 * Servlet implementation class PainterNavServlet
 */
@WebServlet("/painterNavServlet")
public class PainterNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PainterNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String path = "/viewAllPaintersServlet";
		String act = request.getParameter("doThisToPainter");
		
		PainterHelper pth = new PainterHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPaintersServlet").forward(request, response);
		}else if (act.equals("delete a painter")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Painter painterToDelete = pth.searchForPainterById(tempId);
				pth.deletePainter(painterToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a painter.");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllPaintersServlet").forward(request, response);
			}
		} else if (act.equals("edit a painter")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Painter painterToEdit = pth.searchForPainterById(tempId);
				request.setAttribute("painterToEdit", painterToEdit);
				
				PainterHelper pthForPainters = new PainterHelper();
				request.setAttribute("allPainters", pthForPainters.showAllPainters());
				
				if(pthForPainters.showAllPainters().isEmpty()) {
					request.setAttribute("allPainters", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-painter.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a painter.");
			}
		} else if (act.equals("add a painter")) {
			getServletContext().getRequestDispatcher("/new-painter.jsp").forward(request, response);
		}

	}

}
