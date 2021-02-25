package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paint;

/**
 * Servlet implementation class AddPaintServlet
 */
@WebServlet("/addPaintServlet")
public class AddPaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brand = request.getParameter("BrandName");
		String color = request.getParameter("ColorName");
		String medium = request.getParameter("Medium");
		
		Paint p = new Paint(brand, color, medium);
		PaintHelper ph = new PaintHelper();
		ph.insertPaint(p);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
