import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BasicEnemy extends GameObject{

	public BasicEnemy(float x, float y, ID id) {
		super(x, y, id);

		velX = 3;
		velY = 3;
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16);
	}//Collision Boundary

	public void tick() {

		x+= velX;
		y+= velY;
		
		if(y <= 0 || y >= Game.HEIGHT -48) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH -16) velX *= -1;
		//prevents from exiting screen
	}


	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y,  16, 16);
		
		
	}

}
