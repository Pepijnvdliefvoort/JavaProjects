import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Drawing extends Canvas {
	private static final long serialVersionUID = 1L;
	
	
	public void paint(Graphics g) {
		//Oval (Circle)
        g.fillOval(10, 10, 50, 50);
        ///Rectangle
        g.fillRect(10, 80, 50, 50);
        
        //Line & line thickness
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        g2.drawLine(20, 160, 180, 160);
        g2.drawLine(270, 20, 270, 70);
        
        //String
        g.drawString("Pepijn van de Liefvoort", 10, 200);
        
    }
	
}
