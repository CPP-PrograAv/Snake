package base;

import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Snake extends JPanel{
	
//	private int velx =4;
//	private int vely =4;
	private int size;
	
	private int posx=0;
	private int posy=0;
//	int xa=velx; //velocidad, utilizar mas adelante..
//	int ya=vely;

	public Snake(int size) {
		this.size = size;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillRect(posx, posy, size, size);
	}

	public void move(int dx, int dy) {
		this.posx+=dx;
		this.posy+=dy;
	}		
	
	public void setUbicacion(int dx,int dy) {
		this.posx =dx;
		this.posy = dy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	
	
}
