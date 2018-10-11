package base;

import java.awt.Graphics2D;

public class Item extends GameObject{

	
	public Item(int s) {
		super(s,50,50);	
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
	
	
	
	
	
}
