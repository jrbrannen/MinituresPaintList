package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paint;
import model.Painter;

/**
 * Servlet implementation class CreateNewPainterServlet
 */
@WebServlet("/createNewPainterServlet")
public class CreateNewPainterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPainterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PainterHelper pth = new PainterHelper();
		PaintHelper ph = new PaintHelper();
		
		String painterName = request.getParameter("name");
		
		System.out.println("Painer Name: " + painterName);
		
		String age = request.getParameter("age");
		String technique = request.getParameter("technique");
		int intAge = 0;
		try {
			intAge = Integer.parseInt(age);
		}catch(NumberFormatException ex) {
			age = null;
		}
		
		
		
		String[] selectedPaints = request.getParameterValues("allPaintsToAdd");
		List<Paint> selectedPaintsForList = new ArrayList<Paint>();
		
		if(selectedPaints != null && selectedPaints.length > 0) {
			for(int i = 0; i<selectedPaints.length; i++) {
				System.out.println(selectedPaints[i]);
				Paint p = ph.searchForPaintById(Integer.parseInt(selectedPaints[i]));
				selectedPaintsForList.add(p);
			}
		}
		
		Painter painter = new Painter(painterName, intAge, technique);
		pth.insertPainter(painter);
		System.out.println("Sucess!");
		
		getServletContext().getRequestDispatcher("/viewAllPaintersServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
