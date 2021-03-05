import java.util.List;

import controller.PainterHelper;
import model.Painter;

/**
 * 
 */

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 3, 2021
 */
public class PaintersTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Painter jeremy = new Painter("Jeremy", 35, "air brush");
		
		PainterHelper pth = new PainterHelper();
		
		pth.insertPainter(jeremy);
		
		
		List<Painter> allPainters = pth.showAllPainters();
		for(Painter p: allPainters) {
			System.out.println(p.toString());
		}

	}

}
