package map.upgrade;
import java.awt.Rectangle;

import javax.swing.JTextField;

public class MakeUpgradeSquares {
	protected Rectangle square;
	protected String name;
	protected boolean isUpgraded;
	protected int pointREC;
	
	private JTextField textFeild;
	
	public MakeUpgradeSquares(String nameOfUpgrade,int x,int y,int width,int height) {
		this.isUpgraded=false;
		this.pointREC=30;
		this.square=new Rectangle(x,y,width,height);
		this.name=nameOfUpgrade;
	}
	public void setUpgraded() {
		this.isUpgraded=true;
		System.out.print("climate_control WAS UPGRADED");
	}
}