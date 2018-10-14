package base;

import java.awt.Graphics2D;

public class Item extends GameObject{
	
	public static int IdItem = -1;
	
	public Item(int size) {
		super(size,(int)(Math.random()*(Escenario.ANCHO/Escenario.size - 1)),
					(int)(Math.random()*(Escenario.LARGO/Escenario.size - 1)), IdItem );
		System.out.println("Fruta en X: "+getPosX()+" e Y: "+getPosY());
	}
	
	public void setItem(int dx, int dy) {
		setPosition(dx, dy, IdItem);
	}
	
	public void setItem(){
		Escenario.matriz[getPosX()][getPosY()]=0;
		//Acá se debería verificar que no se superponga a la snake o a un powerup
		int x = (int)(Math.random()*(Escenario.ANCHO/Escenario.size - 1));
		int y = (int)(Math.random()*(Escenario.LARGO/Escenario.size - 1));
		setPosition(x,y, IdItem);
		System.out.println("Fruta en X: "+getPosX()+" e Y: "+getPosY());
	}

	@Override
	public void paint(Graphics2D g2d) {
		int size = getSize();
		int padding = Escenario.BORDE/2;

		g2d.fillRect(getPosX()*size + 1 + padding, getPosY()*size + 1 + padding, size-2, size-2);
	}

	public boolean esConsumido(Snake snake) {
		return	this.esColicionado(snake);
	}
	
	
	
	
	
}
