package base;

import org.junit.Assert;
import org.junit.Test;

public class TestGame {
	
	

	@Test
	public void TestMoveLeft() {
		Snake snake = new Snake(20,260,260);
		System.out.println(snake.getPosX()+" "+snake.getPosY());
		snake.move(0, -20);//muevo arriba
		snake.move(-20, 0);//muevo izquierda
		Assert.assertTrue( snake.getPosX() == 240 &&  snake.getPosY() == 240);
		
	}
	
	
	@Test
	public void TestMoveDown() {
		Snake snake = new Snake(20,50,50);
		snake.move(0, 20);
		Assert.assertTrue( snake.getPosX() == 50 && snake.getPosY() == 70);
	}
	
	@Test
	public void TestEatItem() {
		int size = 20;
		Snake snake = new Snake(size,200,200);
		Item item = new Item(size);
		item.setItem(220, 200); //setteo a una posicion a la derecha
		snake.move(20, 0); //mueve derecha
		Assert.assertTrue( item.esConsumido(snake));
	}
	
	@Test
	public void TestCrecimientoSerpiente() {
		
		int size = 20;
		Snake snake = new Snake(size,300,300);
		int cuerpoOriginal = snake.getSizeSnake();
		Item item = new Item(size);
	
		item.setItem(320, 300); //setteo a una posicion a la derecha
		snake.move(20, 0); //mueve derecha y como el item
		
		if(item.esConsumido(snake)) 
			snake.crecer();

		Assert.assertTrue(snake.getSizeSnake()==(cuerpoOriginal+1));
	}
	
	@Test
	public void TestGiro180Grados() {
		Snake snake = new Snake(20,160,160); // se instancia moviendo a la derecha con un cuerpo
											
		snake.move(-20, 0); //mover izquierda, al estar apuntado a la derecha, hacer un giro de este tipo provocaria que se muera.
							//no permitido.
		
		Assert.assertTrue(snake.muerto == true);
	
		
	}
	
	@Test
	public void TestColisionCuerpo() {
		
		int size=20;
		Snake snake = new Snake(size,120,120);
		Snake snake2 = new Snake(size,140,140);
		boolean estadoOriginal = snake.muerto;
		snake.move(0,size );	//muevo abajo y colisiono con el cuerpo de la otra
		Assert.assertTrue( snake.muerto==true && estadoOriginal==false && snake2.muerto==false);

		
	}
	
	@Test
	public void TestColisionCabezas() {
		int size=20;
		Snake snake = new Snake(size,60,60);
		Snake snake2 = new Snake(size,60,80);
		boolean estadoOriginal = snake.muerto;
		snake.move(0, size);
//		Escenario.mostrarmatriz();
		
	}
	
	

}
