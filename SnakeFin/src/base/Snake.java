package base;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Snake extends GameObject {
	
	private static int ID = ++idgeneral;
	protected static int IDcuerpo = 99;//para darle un id a los cuerpos
	//private static int IDcabeza = 1;
	private int idSnake;
	protected boolean muerto= false;
	boolean comer=false;
	int i=0;
	private ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
	
	public Snake(int size, int posX, int posY, int id) {
		super(size, posX, posY, id);//20,4,4,ID
		cuerpos.add( new Cuerpo(posX-1,posY,size,IDcuerpo));//3, 4, 20, ID
		idSnake = id;
	}

	@Override
	public void paint(Graphics2D g2d) {
		int size = getSize();
		int padding = Escenario.BORDE/2;
		g2d.fillRect(getPosX()*size + 1 + padding, getPosY()*size + 1 + padding , size - 2, size - 2);
		for(Cuerpo trozo :cuerpos)
			trozo.paint(g2d);
	}


	public void move(int dx, int dy) {
	
		/*if((Escenario.matriz[getPosX()+dx][getPosY()+dy] == 2  ||
			Escenario.matriz[getPosX()+dy][getPosY()+dx] == 1)	) {
			
			this.muerto = true;
			/*
			 * analizar que hay en ese espacio
			 * item - cabeza - cuerpo
			 */
//			System.out.println("HABRA ALGO" + i++);
//		}
		PredecirCoalicion.Coalicion(getPosX()+dx, getPosY()+dy, this);
		
		for (int i = cuerpos.size() - 1; i >=0; i--) { 
	
			if(i == cuerpos.size()-1 && !comer) 
				Escenario.matriz[cuerpos.get(i).getPosX()]
								[cuerpos.get(i).getPosY()] = 0;
			if(i>0) 
				cuerpos.get(i).setPosition(cuerpos.get(i - 1).getPosX(), cuerpos.get(i - 1).getPosY(), ID);	
			else
				cuerpos.get(i).setPosition(getPosX(), getPosY(), ID);
			comer=false;
		}

		setPosition(getPosX()+dx, getPosY()+dy, ID);//creo que mueve la cabeza
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
		return this.idSnake;
	}
	

}

