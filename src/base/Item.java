package base;

import java.awt.Graphics2D;

public class Item extends GameObject{

	
	public Item(int s) {
		super(s,(int) (Math.random() * (Escenario.ANCHO -s )) ,(int) (Math.random() * (Escenario.LARGO -s )));	
	}
	
	
	public void setItem(int dx, int dy) {
		setPosX(dx);
		setPosY(dy);
	}
	
	public void setItem() {
		setPosX((int) (Math.random() * (Escenario.ANCHO - getSize() )) );
		setPosY((int) (Math.random() * (Escenario.LARGO - getSize() )) );	
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX()+1, getPosY()+1, getSize()-4, getSize()-4);
	}

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}


	public boolean esConsumido(Snake snake) {
		return	this.esColicionado(snake);
	}
	
	
	
	
	
}
