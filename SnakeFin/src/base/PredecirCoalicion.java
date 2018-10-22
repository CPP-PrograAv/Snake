package base;

import java.awt.Graphics2D;

public class PredecirCoalicion{

	
	public static void Coalicion(int x, int y, Snake viboritaQueSemueve) {
		Snake viboritaALaQueChocan;
		int objetoChocado = Escenario.matriz[x][y];
		if(objetoChocado != 0 && objetoChocado != -1 && objetoChocado != 99) {				//si es !=0 y no es un item, ni tampoco el cuerpo de una viborita, choque de cabezas y mato a las 2
			viboritaALaQueChocan = Escenario.viboritas.get(Escenario.matriz[x][y]-1);
			viboritaALaQueChocan.muerto = true;
			viboritaQueSemueve.muerto = true;
		}	
		if(objetoChocado == 99)  															//sino, choco contra un cuerpo y tengo que matarla a ella sola (no importa si es su propio cuerpo o de otra vibora)
			viboritaQueSemueve.muerto = true; 
	}
}
	


	