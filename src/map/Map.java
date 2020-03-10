package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import map.upgrade.Upgrade;

public class Map extends JFrame implements MouseMotionListener,MouseListener{
	private Image earth;
	private Region northAmerica;
	private Region southAmerica;
	private Region europe;
	private Region africa;
	private Region asia;
	private Region australia;
	private int mouseX,mouseY,pointerX,pointerY;
	private Rectangle pointer;
	private boolean mouseClicked;
	private Upgrade upgrade;
	private int points;
	
	public Map() {
		setTitle("PLAGUE INC.");
		setSize(1280,720);
		
		this.points=0;
		this.earth = (new ImageIcon("earth.jpg")).getImage();
		this.upgrade=new Upgrade();
		this.northAmerica=new Region(125,2,350,300,579000000,"cold");
		this.southAmerica=new Region(300,302,210,335,422500000,"hot");
		this.europe=new Region(592,51,200,115,741400000,"cold");
		this.africa=new Region(557,169,300,375,1216000000,"hot");
		this.asia=new Region(859,55,325,350,4463000000L,"hot");
		this.australia=new Region(1075,427,175,150,24600000,"hot");
		
		this.mouseClicked=false;
		addMouseListener(this);
		addMouseMotionListener(this);
		setLocationRelativeTo(null);  
		setResizable(false);
		setVisible(true);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		Image dbImage = createImage(getWidth(),getHeight());
		Graphics dbg = dbImage.getGraphics();
			paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		repaint();

	}
	
	public void paintComponent(Graphics g){
		g.drawImage(this.earth,0,0,null);
		
		//pointer
		this.pointerX=mouseX;
		this.pointerY=mouseY;
		pointer=new Rectangle(this.pointerX,this.pointerY,1,1);
		g.setColor(Color.BLUE);
		g.fillRect(pointer.x, pointer.y, pointer.width, pointer.height);
		
		if(!upgrade.isOpen){
			//crate borders
			g.setColor(Color.YELLOW);
			g.fillRect(upgrade.hitbox.x, upgrade.hitbox.y, upgrade.hitbox.width, upgrade.hitbox.height);
			g.setColor(Color.BLACK);
			g.drawRect(northAmerica.hitbox.x, northAmerica.hitbox.y, northAmerica.hitbox.width, northAmerica.hitbox.height);
			g.drawRect(southAmerica.hitbox.x, southAmerica.hitbox.y, southAmerica.hitbox.width, southAmerica.hitbox.height);
			g.drawRect(europe.hitbox.x, europe.hitbox.y, europe.hitbox.width, europe.hitbox.height);
			g.drawRect(africa.hitbox.x, africa.hitbox.y, africa.hitbox.width, africa.hitbox.height);
			g.drawRect(asia.hitbox.x, asia.hitbox.y, asia.hitbox.width, asia.hitbox.height);
			g.drawRect(australia.hitbox.x, australia.hitbox.y, australia.hitbox.width, australia.hitbox.height);
	
	
			//IFs
			if(pointer.intersects(northAmerica.hitbox)) {
				System.out.print("NORTH AMERICA HIT");
				northAmerica.info(g);
			}
			if(pointer.intersects(southAmerica.hitbox)) {
				System.out.print("SOUTH AMERICA HIT");
				southAmerica.info(g);
			}
			if(pointer.intersects(europe.hitbox)) {
				System.out.print("EUROPE HIT");
				europe.info(g);
			}
			if(pointer.intersects(africa.hitbox)) {
				System.out.print("AFRICA HIT");
				africa.info(g);
			}
			if(pointer.intersects(asia.hitbox)) {
				System.out.print("ASIA HIT");
				asia.info(g);
			}
			if(pointer.intersects(australia.hitbox)) {
				System.out.print("AUSTRALIA HIT");
				australia.info(g);
			}
		
			if(pointer.intersects(upgrade.hitbox)&&mouseClicked==true) {
				upgrade.setOn();
				mouseClicked=false;
			}
			
		}else {
			this.mouseClicked=upgrade.showUpgrades(g,pointer,mouseClicked, points);
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		System.out.println(mouseX+" "+mouseY);
		e.consume();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked=true;
		System.out.print("mouseClicked is: "+mouseClicked);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}