import java.awt.*;

public class AiiBall {
	
	private static final int GRAVITY = 3;  // effect of gravity

    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private AiiCanvas canvas;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public AiiBall(int xPos, int yPos, int ballDiameter,
                         AiiCanvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = Color.yellow;;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        groundPosition = canvas.getHeight();
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     *  
     *  @param xSpeed  left: -1, right: 1 no speed:0
     *  @param ySpeed up: -1, down: 1 no speed: 0
     **/
    public void move(int xSpeed, int ySpeed)
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        ySpeed *= GRAVITY ;
        yPosition += ySpeed;
        xPosition += xSpeed ;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
        }

        // draw again at new position
        draw();
    }
   
    /*
     * the ball jumps up and down
     * 
     * @param height jumpheight
     */
    public void jump(int height)
    {
    	int ySpeed = -1;
    	
    	boolean finished = false;
    	while (!finished)
    	{
                canvas.wait(8);           // small delay
                move( 0,ySpeed);
                
                // stop once ball has travelled a certain distance on y axis
                if (yPosition <= canvas.getHeight() - height)
                	ySpeed = -ySpeed;
        		if (yPosition >= (canvas.getHeight() - diameter))
        		{
        			finished = true;
        		}
          }
    }
    /*
     * rolling the ball over the surface
     * 
     * @param distance the distance to roll
     * @param direction left:-1 right: 1
     */
    public void roll(int distance, int direction)
    {
        boolean finished = false;
        int startX = xPosition;
        int xSpeed = direction;
    	while (!finished)
    	{
    		move(xSpeed,0);
    		
        	if (xPosition <= startX - distance  || xPosition >= startX + distance)
        		xSpeed = -xSpeed;
        	if (xPosition == startX)
        	{
        		finished = true;
        	}
    		canvas.wait(8);
    	}
    }
    
    /* Change color of the ball 
     * 
     * @param color String
     */
    public void changeColor(String color)
    {
    	this.color = Color.decode(color);
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /*
     * The size of the ball is changed
     * 
     * @param diameter new size
     */
    public void setDiameter(int diameter)
    {
    	this.diameter = diameter;
    }
}


