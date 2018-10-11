package base;

import org.junit.Assert;
import org.junit.Test;

public class TestGame {
	
	
	@Test
	public void PruebaMoverIzq() {
		Snake snake = new Snake(20,50,50);
		snake.move(-20, 0);
		Assert.assertTrue( snake.getPosX() == 30 &&  snake.getPosY() == 50);
	}
	
	@Test
	public void PruebaMoverDer() {
		Snake snake = new Snake(20,50,50);
		snake.move(20, 0);
		Assert.assertTrue( snake.getPosX() == 70 &&  snake.getPosY() == 50);
	}
	
	@Test
	public void TestMoveUp() {
		Snake snake = new Snake(20,50,50);
		snake.move(0, -20);
		Assert.assertTrue( snake.getPosX() == 50 && snake.getPosY() == 30);
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
		Snake snake = new Snake(size,50,50);
		Item item = new Item(size);
		item.setItem(70, 50); //setteo a una posicion a la derecha
		snake.move(20, 0); //mueve derecha

		Assert.assertTrue( item.esConsumido(snake));
	}
	
	@Test
	public void TestCrecimientoSerpiente() {
		
		
		
	}
	

}
