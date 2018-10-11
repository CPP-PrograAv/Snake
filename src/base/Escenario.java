package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Escenario extends JFrame{
	
	public static final int ANCHO = 400;
	public static final int LARGO = 400;
	
	//snake
	private int size = 10; // el tamaño de la snake en el escenario?
	Snake snake = new Snake(size,size*2,size*2,4);
	
	//movimientos
	int dy,dx;
	boolean up,down,left,right;
	
	public Escenario() {
		
		super("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,ANCHO,LARGO);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.WHITE);
		//CLASE ANONIMA, MANEJO EVENTOS DE TECLADO
		addKeyListener(new KeyListener() {
			
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
		while (true) {
			move(); //la muevo
			//repaint(); //re pinto la snake
			update(this.getGraphics());
			
			try {
				Thread.sleep(100); //HAGO QUE LOS PROCESOS SE EJECUTEN CADA 100 MILISEGUNDOS
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void update(Graphics g) {
		super.update(g);
		paint(g);
	}
	
	public void paint(Graphics g) {
		super.paint(g); //VUELVO A PINTAR, Y BORRO EL ANTERIOR
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //mejora el dibujo en el tema de los bordes
		g2d.setColor(Color.RED);
		snake.paint(g2d);
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
		//PASAR LOS LIMITES
		if(snake.getPosx()<0) snake.setPosx(ANCHO-10);
		if(snake.getPosy()<0) snake.setPosy(LARGO-10);
		if(snake.getPosx()>ANCHO-10) snake.setPosx(0);
		if(snake.getPosy()>LARGO-10) snake.setPosy(0);
	}
	
	
}
