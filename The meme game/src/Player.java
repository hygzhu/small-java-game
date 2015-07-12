import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends GameObject {
	
	Handler handler;

	public Player(float x, float y, ID id, Handler handler){
		super(x,y,id);
		this.handler = handler;

	}
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,32,32);
	}//collision boundaries

	public void tick() {
	x += velX;
	y += velY;
	
	x = Game.clamp((int)x, 0, Game.WIDTH - 37);
	y = Game.clamp((int)y, 0, Game.HEIGHT - 60);
	//prevent player from leaving game area
	
	collision();
	}
	private void collision(){
		for (int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy||tempObject.getID() == ID.YellowEnemy){ //tempObject is now basic enemy
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH-=2;
				}
				
				//collision code for basic enemy
			}else if (tempObject.getID() == ID.SmartEnemy){ 
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH-=2;
				}
				
				//collision code for smart enemy
			}
			
		}
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.drawRect((int)x,(int)y,32,32);
		
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File("Images//hz.png"));
//		} catch (IOException e) {
//		}	
//		g.drawImage(img, (int)x, (int)y, null);
		
	}
	
	
	
}
