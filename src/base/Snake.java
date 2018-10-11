package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake extends GameObject {
	
//	private int vel = 1;
	private ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
	
	public Snake(int size, int posX, int posY) {
		super(size, posX, posY);
		cuerpos.add( new Cuerpo(posX-size,posY,size));
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX() + 1, getPosY() + 1 , getSize() - 1, getSize() - 1);
		for(Cuerpo trozo :cuerpos) 
			trozo.paint(g2d);
	}

	@Override
	public void move(int dx, int dy) {

		for (int i = cuerpos.size() - 1; i > 0; i--)
			cuerpos.get(i).setPosition(cuerpos.get(i - 1).getPosX(), cuerpos.get(i - 1).getPosY());
		cuerpos.get(0).setPosition(getPosX(), getPosY());

		setPosX(getPosX()+dx);
		setPosY(getPosY()+dy);
	}
	
	public void crecer() {
//		cuerpos.add( new Cuerpo(-100,-100,getSize()) ); // hago que el cuerpo aparesca afuera de la ventana, pero al agregarlo a la lista
														//el proximo move tendra en cuenta este ultimo elemento agregado	
	}
		
	
	
}

