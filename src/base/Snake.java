package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Snake extends JPanel{
	
	private int vel = 1;
	private int size;
	
	private int posx=0;
	private int posy=0;
	private ArrayList<Cuerpo> cuerpo;
	
	private float mov;
	

	public Snake(int size) {
		this.size = size;
		cuerpo = new ArrayList<Cuerpo>();
		for(int i = 0;i<2;i++)
			cuerpo.add(new Cuerpo(0,0+i));
	}
	
	public Snake(int size, int posX, int posY) {
		this.size = size;
		this.posx = posX;
		this.posy = posY;
		cuerpo = new ArrayList<Cuerpo>();
		for(int i = 0;i<2;i++)
			cuerpo.add(new Cuerpo(posX,posY+i));
	}
	public Snake(int size, int posX, int posY,int longitud) {
		this.size = size;
		this.posx = posX;
		this.posy = posY;
		cuerpo = new ArrayList<Cuerpo>();
		for(int i = 0;i<longitud;i++)
			cuerpo.add(new Cuerpo(posX,posY+i*size));
		
	}

	public void paint(Graphics2D g2d) {
		g2d.fillRect(posx, posy, size, size);
		for(Cuerpo trozo :cuerpo) {
			trozo.paint(g2d);
		}
	}

	public void move(int dx, int dy) {
		this.posx+=dx;
		this.posy+=dy;
		for(Cuerpo trozo :cuerpo) {
			trozo.mover(dx,dy);
		}
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
