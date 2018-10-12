package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake extends GameObject {
	
//	private int vel = 1;
	boolean muerto= false;
	boolean comer=false;
	int i=0;
	private ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
	
	public Snake(int size, int posX, int posY) {
		super(size, posX, posY);
		cuerpos.add( new Cuerpo(posX-size,posY,size));
		
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX() + 1, getPosY() + 1 , getSize() - 2, getSize() - 2);
		for(Cuerpo trozo :cuerpos)
			trozo.paint(g2d);
	}

	
	public void move(int dx, int dy) {
		
//		System.out.println((getPosY()+dy)/getSize() + " "+(getPosX()+dx)/getSize());
//		System.out.println(Escenario.matriz[(getPosX()+dx)/getSize()][(getPosY()+dy)/getSize()] );
	
		if(Escenario.matriz[(getPosY()+dy)/getSize()][(getPosX()+dx)/getSize()] == 1) {
//			crecer();
			/*
			 * 
			 * analizar que hay en ese espacio
			 * item - cabeza - cuerpo
			 * 
			 */
			System.out.println("HABRA ALGO" + i++);
		}
		
		for (int i = cuerpos.size() - 1; i >=0; i--) { 
	
			if(i == cuerpos.size()-1 && !comer) {
				Escenario.matriz[cuerpos.get(i).getPosY()/getSize()]
						[cuerpos.get(i).getPosX()/getSize()] = 0;
//				System.out.println("EENTROOOO");
				}
			
			if(i>0) 
				cuerpos.get(i).setPosition(cuerpos.get(i - 1).getPosX(), cuerpos.get(i - 1).getPosY());	
			else
				cuerpos.get(0).setPosition(getPosX(), getPosY());
			comer=false;
		}

		setPosition(getPosX()+dx, getPosY()+dy);	
		
		
		/*	aca tendriamos que pensar la forma de saber si en esa posicion que se movio, ya habia algo distinto al item
		 *  si era algo distinto a un item, la head snake tendria que pasar un estado muerto.
		 */
		
	}
	
	public void crecer() {
		cuerpos.add( new Cuerpo(getSize()) ); // hago que el cuerpo aparesca afuera de la ventana, pero al agregarlo a la lista
		comer=true;	
//		int x =200;
//		Item item = new Item(getSize());
//		item.setPosition(x,80);
//		x+=100;
			//el proximo move tendra en cuenta este ultimo elemento agregado	
	}

	public boolean coliciona() {
		for (int i = cuerpos.size() - 1; i > 0; i--) {	
			if(cuerpos.get(i).esColicionado(this))
				return  true;
		}
		
		return false;
	}
	
	public int getSizeSnake() {
		return this.cuerpos.size();
	}
}

