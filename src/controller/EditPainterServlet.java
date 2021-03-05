package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Painter;

/**
 * Servlet implementation class EditPainter
 */
@WebServlet("/editPainterServlet")
public class EditPainterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPainterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PainterHelper pth = new PainterHelper();
		
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String technique = request.getParameter("technique");
		Integer tempId	= Integer.parseInt(request.getParameter("id"));
		
		Painter painterToUpdate = pth.searchForPainterById(tempId);
		
		painterToUpdate.setName(name);
		painterToUpdate.setAge(age);
		painterToUpdate.setTechnique(technique);
		
		pth.updatePainter(painterToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPaintersServlet").forward(request, response);
	}

}
