package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Escenario extends JFrame{
	

	public static final int ANCHO = 400;
	public static final int LARGO = 400;
	private JPanel contentPane;
	
	//snake
	private int size = 20;
	Snake snake = new Snake(size);
	
	//movimientos
	int dy,dx;
	boolean up,down,left,right;
	
	public Escenario() {
		
		super("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,ANCHO,LARGO);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0)); //no se para q es esto..
		contentPane.setLayout(new BorderLayout(0,0)); // no se para que es esto
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		
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
			repaint(); //re pinto la snake
			
			try {
				Thread.sleep(100); //HAGO QUE LOS PROCESOS SE EJECUTEN CADA 100 MILISEGUNDOS
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
		if(snake.getPosx()<0) snake.setPosx(ANCHO);
		if(snake.getPosy()<0) snake.setPosy(LARGO);
		if(snake.getPosx()>ANCHO) snake.setPosx(0);
		if(snake.getPosy()>LARGO) snake.setPosy(0);
		
	}
	
	
}
