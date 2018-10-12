package base;

import java.awt.Graphics2D;

public class Item extends GameObject{
	
	public static int IdItem = -1;
	
	public Item(int size) {
		super(size,	((int)(Math.random()*(Escenario.ANCHO - size))/size)*size,
					((int)(Math.random()*(Escenario.LARGO - size))/size)*size, IdItem );	
	}
	
	public void setItem(int dx, int dy) {
		setPosition(dx, dy, IdItem);
	}
	
	public void setItem(){
		Escenario.matriz[getPosY()/getSize()][getPosX()/getSize()]=0;
		int y = ((int)(Math.random()*(Escenario.ANCHO - getSize()))/getSize())*getSize();
		int x = ((int)(Math.random()*(Escenario.LARGO - getSize()))/getSize())*getSize();
		setPosition(x,y, IdItem);
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX()+1, getPosY()+1, getSize()-2, getSize()-2);
	}

	public boolean esConsumido(Snake snake) {
		return	this.esColicionado(snake);
	}
	
	
	
	
	
}
