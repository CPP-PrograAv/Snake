package base;

import java.awt.Graphics2D;

public class Cuerpo {
	private int posx=0;
	private int posy=0;
	
	public Cuerpo(int posX, int posY) {
		this.posx = posX;
		this.posy = posY;
	}
	
	public void mover(int dx, int dy) {
		this.posx+=dx;
		this.posy+=dy;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillRect(posx, posy, 20, 20);
	}
}
