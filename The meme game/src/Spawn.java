import java.util.Random;


public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		
		scoreKeep++;
		if(scoreKeep >= 200){
			scoreKeep =0;
			hud.setLevel(hud.getLevel()+1);
			
			handler.addObject(new YellowEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.YellowEnemy));
			
			if(hud.getLevel()==5){
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			}
		
			
			
		}
		
	}
}
