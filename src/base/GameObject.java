package base;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	private int posX,posY;
	private int size;
	public static int idgeneral = 0;
	
	public GameObject(int s) {
		this.size=s;
	}
	
	public GameObject(int s, int posX, int posY, int ID) {
		this.posX = posX;
		this.posY = posY;
		this.size = s;
		Escenario.matriz[posX][posY] = ID;
	}
	
	public abstract void paint(Graphics2D g2d);
	
	public void setPosition(int posX, int posY, int ID) {
		this.posX = posX;
		this.posY = posY;
		Escenario.matriz[this.posX][this.posY] = ID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Rectangle getBound() {
		return new Rectangle(posX*size, posY*size, size, size);
	}
	
	public boolean esColicionado(GameObject obj) {	
		if(obj == this) return false;
		return getBound().intersects(obj.getBound());
	}

	
	
}
