package base;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class Escenario extends JFrame{
	
	public static final int ANCHO = 500;
	public static final int LARGO = 500;
	public static final int BORDE = 100;
	
	public static int size = 20;
	//snake
	Snake snake = new Snake(size,80/size,80/size);
	Item item = new Item(size);
	Snake snake2 = new Snake(size,200/size,200/size);
	public static int matriz[][] = new int[ANCHO/size][LARGO/size];
	
	//movimientos
	int dy,dx;
	boolean up,down,left,right=true;
	
	public Escenario() {
	
		super("Game");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,ANCHO+BORDE,LARGO+BORDE);
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
//
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

	private void mostrarmatriz() {
		// TODO Auto-generated method stub
		for(int i=0; i<ANCHO/size; i++) {
			for(int j=0; j<ANCHO/size;j++) 
				System.out.print(matriz[j][i]+" ");
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
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, ANCHO+BORDE, BORDE/2);//borde superior
		g2d.fillRect(ANCHO+BORDE/2, 0, BORDE/2, LARGO+BORDE); //borde derecho
		g2d.fillRect(0, 0, BORDE/2, LARGO+BORDE); //borde izquierdo
		g2d.fillRect(0, LARGO+BORDE/2, ANCHO+BORDE, BORDE/2);//borde inferior
	}
	
	private void move() {
		
		if(up && dy==0) { //LA SEGUNDA PREGUNTA ES PARA EVITAR QUE VUELVA PARA ATRAS, LA CABEZA DEBERIA MOVERSE PARA CUALQUIER LADO?
			dy=-1;
			dx=0;
		}
		
		if(down && dy==0) {
			dy=1;
			dx=0;
		}
		
		if(left && dx==0) {
			dx=-1;
			dy=0;
		}
		
		if(right && dx==0) {
			dx=1;
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
		if(snake.getPosX()==0 && (dx==-1 || dy!=0)) snake.setPosX((ANCHO-size)/size);
		if(snake.getPosY()==0 && (dy==-1 || dx!=0)) snake.setPosY((LARGO-size)/size);
		if(snake.getPosX()==(ANCHO-size)/size && (dx==1 || dy!=0)) snake.setPosX(0);
		if(snake.getPosY()==(LARGO-size)/size && (dy==1 || dx!=0)) snake.setPosY(0);
		
	}
	
	
}
