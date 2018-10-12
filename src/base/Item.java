package base;

import java.awt.Graphics2D;

public class Item extends GameObject{

	
	public Item(int s) {
		super(s,120,80);	
	}
	
	
	public void setItem(int dx, int dy) {
		setPosition(dx, dy);
	}
	
	public void setItem() {
		Escenario.matriz[getPosY()/getSize()][getPosX()/getSize()]=0;
		int y = ((int)(Math.random()*(Escenario.ANCHO - getSize()))/getSize())*getSize();
		int x = ((int)(Math.random()*(Escenario.LARGO - getSize()))/getSize())*getSize();
		setPosition(x,y);
		

	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX()+1, getPosY()+1, getSize()-2, getSize()-2);
	}


	public boolean esConsumido(Snake snake) {
		return	this.esColicionado(snake);
	}
	
	
	
	
	
}
