package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake extends GameObject {
	
	private static int ID = ++idgeneral;
	boolean muerto= false;
	boolean comer=false;
	int i=0;
	private ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
	
	public Snake(int size, int posX, int posY) {
		super(size, posX, posY, ID);
		cuerpos.add( new Cuerpo(posX-size,posY,size,ID));
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.fillRect(getPosX() + 1, getPosY() + 1 , getSize() - 2, getSize() - 2);
		for(Cuerpo trozo :cuerpos)
			trozo.paint(g2d);
	}


	public void move(int dx, int dy) {
	
		if(Escenario.matriz[(getPosY()+dy)/getSize()][(getPosX()+dx)/getSize()] != 0  &&
			Escenario.matriz[(getPosY()+dy)/getSize()][(getPosX()+dx)/getSize()] != -1) {
			
			this.muerto = true;
			/*
			 * analizar que hay en ese espacio
			 * item - cabeza - cuerpo
			 */
//			System.out.println("HABRA ALGO" + i++);
		}
		
		for (int i = cuerpos.size() - 1; i >=0; i--) { 
	
			if(i == cuerpos.size()-1 && !comer) 
				Escenario.matriz[cuerpos.get(i).getPosY()/getSize()]
								[cuerpos.get(i).getPosX()/getSize()] = 0;
			
			if(i>0) 
				cuerpos.get(i).setPosition(cuerpos.get(i - 1).getPosX(), cuerpos.get(i - 1).getPosY(), ID);	
			else
				cuerpos.get(0).setPosition(getPosX(), getPosY(), ID);
			comer=false;
		}

		setPosition(getPosX()+dx, getPosY()+dy, ID);	
	}
	
	public void crecer() {
		cuerpos.add( new Cuerpo(getSize()) ); 	// hago que el cuerpo aparesca afuera de la ventana,
												// pero al agregarlo a la lista
		comer=true;	
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
	
	public int getIdSnake() {
		return this.ID;
	}
	

}

