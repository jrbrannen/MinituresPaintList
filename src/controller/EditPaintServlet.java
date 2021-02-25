package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paint;

/**
 * Servlet implementation class EditPaintServlet
 */
@WebServlet("/editPaintServlet")
public class EditPaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPaintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaintHelper ph = new PaintHelper();
		
		String brand = request.getParameter("BrandName");
		String color = request.getParameter("ColorName");
		String medium = request.getParameter("Medium");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		
		Paint paintToUpdate = ph.searchForPaintById(tempId);
		
		paintToUpdate.setBrand(brand);
		paintToUpdate.setColor(color);
		paintToUpdate.setMedium(medium);
		
		ph.updateItem(paintToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPaintsServlet").forward(request, response);
	}

}
