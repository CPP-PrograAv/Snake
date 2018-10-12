package base;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cuerpo extends GameObject{
	 
	public Cuerpo(int size) {
		super(size);
	}
	
	public Cuerpo(int posX, int posY, int size) {
		super(size, posX, posY);
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(getPosX() + 1, getPosY() + 1, getSize() - 2, getSize() - 2);
	}
	 
}
