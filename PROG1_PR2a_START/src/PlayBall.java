

public class PlayBall {
	
	@SuppressWarnings("unused")
	private AiiCanvas canvas ;
	private int windowWidth;
	private int windowHeight;
	private AiiBall ball;
	private int ballDiameter = 20;
    
	/*
	 * Constructor
	 * 
	 */
	public PlayBall(AiiCanvas canvas) {       
		this.canvas = canvas;
		// windowWidth becomes the width of the playfield
		windowWidth = canvas.getWidth();
		// // windowHeight becomes the height of the playfield
		windowHeight = canvas.getHeight();
		// the ball is created and placed on the playfield
		ball = new AiiBall(windowWidth/2 - ballDiameter/2, windowHeight - ballDiameter, ballDiameter,canvas);
		ball.draw();
	    playWithBall();
	}
	
	/*
	 * the ball moves over the playfield. It can jump up and down and
	 * it can roll over the surface
	 */
	public void playWithBall()
	{
		int jumpHeight = 500;	
//		int rollDistance = 100;
		int direction = 5; //1 -> to the right, -1 to the left
		
		if(jumpHeight >= windowHeight) {
			jumpHeight = windowHeight;
		}
		if(direction < -1) {
			direction = -1;
		}
		else if(direction > 1) {
			direction = 1;
		}
		else if(direction == 0) {
			direction = 1;
		}
//		if(rollDistance < 0) {
//			rollDistance = 0;
//		}
		
		//ball.jump(jumpHeight);

		
		bounceBox(direction, 1);
		
		
	}
	
	
	public void bounceBox(int Xdir, int Ydir) {
		int Xpos = ball.getXPosition();
		int Ypos = ball.getYPosition();
	
//		System.out.print(Ypos + "\n");
//		System.out.print(windowHeight +"\n");
		
		
		
		//Horizontal speed
		if(Xpos == this.windowWidth - this.ballDiameter) {
			Xdir = -1;
		}
		else if(Xpos == this.windowWidth - (this.windowWidth -1)) {
			Xdir = 1;
		}
		
		//Vertical speed
		if(Ypos == this.windowHeight + this.ballDiameter) {
			Ydir = -1;
		}
		else if(Ypos == this.windowHeight + (this.windowHeight + 1)) {
			Xdir = 1;
		}
		
		//Move the ball
		ball.move(Xdir, Ydir);
		
		
		//Try catch for Thread.Sleep
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Call function for loop
		bounceBox(Xdir, Ydir);
	}
}