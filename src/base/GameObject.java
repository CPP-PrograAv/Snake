package base;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	private int posX,posY;
	private int size;
	
	public GameObject(int s) {
		this.size=s;
	}
	
	public GameObject(int s, int posX, int posY, int ID) {
		this.posX = posX;
		this.posY = posY;
		this.size = s;
		Escenario.matriz[posY/size][posX/size] = ID;
	}
	
	public abstract void paint(Graphics2D g2d);
	
	public void setPosition(int posX, int posY, int ID) {
		this.posX = posX;
		this.posY = posY;
		Escenario.matriz[this.posY/this.size][this.posX/this.size] = ID;
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
		return new Rectangle(posX, posY, size, size);
	}
	
	public boolean esColicionado(GameObject obj) {	
		if(obj == this) return false;
		return getBound().intersects(obj.getBound());
	}

	public GameObject obtenerObjPos() {
		return this;
	}
	
	
}
