package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Region {
	protected Rectangle hitbox;
	protected long population;
	protected String climate;
	protected int infected;
	protected int dead;
	
	public Region(int x,int y,int width,int hight,long population,String climate) {
		this.hitbox=new Rectangle(x,y,width,hight);
		this.population=population;
		this.climate=climate;
		this.infected=0;
		this.dead=0;
	}
	
	public void info(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(411, 654, 450, 200);
		g.setColor(Color.WHITE);
		g.drawString("Population: "+Long.toString(this.population), 444, 675);
		g.drawString("Climate: "+this.climate, 444, 690);
		g.drawString("Infected: "+Integer.toString(this.infected), 704, 675);
		g.drawString("Dead: "+Integer.toString(this.dead), 704, 690);
	}
}