package base;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cuerpo extends GameObject{
	 
	public Cuerpo(int size) {
		super(size);
	}
	
	public Cuerpo(int posX, int posY, int size,int id) {
		super(size, posX, posY,id);
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		int size = getSize();
		int padding = Escenario.BORDE/2;

		g2d.fillRect(getPosX()*size + 1+ padding, getPosY()*size + 1 + padding, size - 2, size - 2);
	}
	 
}
