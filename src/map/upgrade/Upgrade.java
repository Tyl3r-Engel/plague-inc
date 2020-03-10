package map.upgrade;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Upgrade{
	public Rectangle hitbox;
	public boolean isOpen;
	private Rectangle closeButton;
	
	private MakeUpgradeSquares climate_control;
	
	public Upgrade() {
		this.hitbox=new Rectangle(0,670,50,50);
		this.closeButton=new Rectangle(1235, 30,25,25);
		this.climate_control=new MakeUpgradeSquares("climate control",128,476,50,50);
	}
	
	public boolean showUpgrades(Graphics g,Rectangle pointer,boolean mouseClicked,int points){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 2000, 2000);
		g.setColor(Color.RED);
		g.fillRect(closeButton.x, closeButton.y, closeButton.width, closeButton.height);
		
		//climate_control
		g.fillRect(this.climate_control.square.x, this.climate_control.square.y, this.climate_control.square.width, this.climate_control.square.height);
		if(pointer.intersects(this.climate_control.square)&&mouseClicked==true) {
			if(points>=climate_control.pointREC)
				climate_control.setUpgraded();
			else {
				g.drawString("You dont have that many points", 512, 642);
			
				
			}
		}
		
		
		
		
		if(pointer.intersects(this.closeButton)&&mouseClicked==true) {
			setOff();
		}
		return false;
	}
	
	public void setOn() {
		isOpen=true;
	}
	
	public void setOff() {
		isOpen=false;
	}
}