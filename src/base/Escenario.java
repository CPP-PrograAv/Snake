package base;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Escenario extends JFrame{
	
	public static final int ANCHO = 600;
	public static final int LARGO = 600;
	
	//snake
	private static int size = 20;
	Snake snake = new Snake(size,80,80);
	Item item = new Item(size);
	
	
	ArrayList<Integer> ListaMuertos = new ArrayList<Integer>();
	
	
	Snake snake2 = new Snake(size,200,200);
	public static int matriz[][] = new int[ANCHO/size][LARGO/size];
	
	//movimientos
	int dy,dx; 
	boolean up,down,left,right=true;
	
	public Escenario() {
	
		super("Game");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,ANCHO,LARGO);
		setLocationRelativeTo(null);
		setVisible(true);

		//CLASE ANONIMA, MANEJO EVENTOS DE TECLADO
				addKeyListener(new KeyListener(){
	
					@Override
					public void keyTyped(KeyEvent e) {
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_LEFT) left =false;
						if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
						if(e.getKeyCode() == KeyEvent.VK_UP) up = false;
						if(e.getKeyCode() == KeyEvent.VK_DOWN) down =false;
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_LEFT) left =true;
						if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
						if(e.getKeyCode() == KeyEvent.VK_UP) up = true;
						if(e.getKeyCode() == KeyEvent.VK_DOWN) down = true;

					}
				});
		
	}
	
	public void start() {
		System.out.println(snake.getIdSnake());
		System.out.println(snake2.getIdSnake());
		
		
		while (true) {
//			mostrarmatriz();
//			System.out.println("\n\n");
//			snake.move(size,0); //la muevo
			
			move();
			
			update( this.getGraphics() );//re pinto la snake, preguntar por repaint();
			try {
				Thread.sleep(100); //HAGO QUE LOS PROCESOS SE EJECUTEN CADA 100 MILISEGUNDOS
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mostrarmatriz() {
		// TODO Auto-generated method stub
		for(int i=0; i<ANCHO/size; i++) {
			for(int j=0; j<ANCHO/size;j++) 
				System.out.print(matriz[i][j]+" ");
		System.out.println("\n");
		}
	}

	public void paint(Graphics g) {
		super.paint(g); //VUELVO A PINTAR, Y BORRO EL ANTERIOR
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //mejora el dibujo en el tema de los bordes
		
		g2d.setColor(Color.RED);
		snake.paint(g2d);
		
		g2d.setColor(Color.GREEN);
		item.paint(g2d);
		
		g2d.setColor(Color.BLUE);
		snake2.paint(g2d);
		
	}
	
	private void move() {
		
		if(up && dy==0) { //LA SEGUNDA PREGUNTA ES PARA EVITAR QUE VUELVA PARA ATRAS, LA CABEZA DEBERIA MOVERSE PARA CUALQUIER LADO?
			dy=-size;
			dx=0;
		}
		
		if(down && dy==0) {
			dy=size;
			dx=0;
		}
		
		if(left && dx==0) {
			dx=-size;
			dy=0;
		}
		
		if(right && dx==0) {
			dx=size;
			dy=0;
		}
		
		snake.move(dx,dy);
		
		if(snake.muerto) {
			System.out.println("Muerto");
		}
		
		if(item.esConsumido(snake)) {
			item.setItem();
			snake.crecer();
		}
								
		//PASAR LOS LIMITES
//		if(snake.getPosX()==20) snake.setPosX(ANCHO-40);
//		if(snake.getPosY()==20) snake.setPosY(LARGO-20);
//		if(snake.getPosX()==ANCHO-20) snake.setPosX(20);
//		if(snake.getPosY()==LARGO-20) snake.setPosY(40);
		
	}
	
	
}
