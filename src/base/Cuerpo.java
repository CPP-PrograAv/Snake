package base;

import java.awt.Graphics2D;

public class Cuerpo {
	private int posx=0;
	private int posy=0;
	private int size=0;
	
	public Cuerpo(int posX, int posY) {
		this.posx = posX;
		this.posy = posY;
		this.size = 10;
	}
	public Cuerpo(int size,int posX, int posY) {
		this.posx = posX;
		this.posy = posY;
		this.size = size;
	}
	
	public void mover(int i, int dx,int dy) {
		posx = dx;
		posy = dy;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillRect(posx, posy, size, size);
	}
	
	public void setPosition(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}
	
	public int getPosX() {
		return posx;
	}
	public int getPosY() {
		return posy;
	}
}
