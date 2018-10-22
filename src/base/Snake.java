package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake extends GameObject {
	
	static int ID = 1;
	boolean muerto= false;
	boolean comer=false;
	int i=0;
	private ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
	
	public Snake(int size, int posX, int posY) {
		super(size, posX, posY, ID++);
		
		cuerpos.add( new Cuerpo(posX-size,posY,size,ID));
		ID++;
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
			if(Escenario.matriz[(getPosY()+dy)/getSize()][(getPosX()+dx)/getSize()]%2 == 1) //es la cabeza de un jugador
				Escenario.matriz[(getPosY()+dy)/getSize()][(getPosX()+dx)/getSize()]=-2;	//nop
				//usar una lista de muertos?
			/*
			 * analizar que hay en ese espacio
			 * item - cabeza - cuerpo
			 * llamar a destructor?
			 */
//			System.out.println("HABRA ALGO" + i++);
		}	else { //no esta muerto
			
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
	}
	
	public void crecer() {
		cuerpos.add( new Cuerpo(getSize()) ); 
		comer=true;	
	}
	
//	public boolean coliciona() {
//		for (int i = cuerpos.size() - 1; i > 0; i--) {	
//			if(cuerpos.get(i).esColicionado(this))
//				return  true;
//		}
//		return false;
//	}

	public int getSizeSnake() {
		return this.cuerpos.size();
	}
	
	public int getIdSnake() {
		return this.ID;
	}
	
	public Snake obtenerSnake() {
		return this;
	}
	
}

