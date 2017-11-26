
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BowlingGameTest {

	@Test
	public void open1() {
		BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, b.getScore());
	}
	
	@Test
	public void strike1() {
		//test git commit 
		BowlingGame b = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, b.getScore());
	}
	
	@Test
	public void spare1() {
		BowlingGame b = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, b.getScore());
	}
	
	@Test
	public void spare2() {
		BowlingGame b = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(98, b.getScore());
	}

	@Test
	public void strikes2() {
		BowlingGame b = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(112, b.getScore());
	}
	
	@Test
	public void strikeSpare() {
		BowlingGame b = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(103, b.getScore());
	}
	
	@Test
	public void spareLast() {
		BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		assertEquals(90, b.getScore());
	}
	
	@Test
	public void strikeLast() {
		BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		assertEquals(92, b.getScore());
	}

	@Test
	public void spareStrike2() {
		BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(93, b.getScore());
	}
	
	@Test
	public void perfect() {
		BowlingGame b = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, b.getScore());
	}
	
	@ParameterizedTest 
	@ValueSource(strings = {"[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0]", 
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8]", 
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1]"})
	public void omitLast(String test) {
		BowlingGame b = new BowlingGame(test);
		assertEquals(-1, b.getScore());
	}
	
	@ParameterizedTest 
	@ValueSource(strings = {"[1,5][7,2][3,6][4,4][5,3][3][4,5][8,1][10,0][7,2]", 
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][2,8][7]", 
		"[3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]",
		"[1,5][3,6][7,2][3,6][4,4][3][3,3][4,5][8,1][2,8][7]"})
	public void omit(String test) {
		BowlingGame b = new BowlingGame(test);
		assertEquals(-1, b.getScore());
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {"[1,5][3,6][7,2][3,6][4,4][5,3][-1,3][4,5][8,1][2,8][10]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][-10]",
		"[1,5][-100,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][-1,-3][4,5][8,1][2,8][10]"})
	public void negative(String test) {
		BowlingGame b = new BowlingGame(test);
		assertEquals(-1, b.getScore());
	}
	

	@ParameterizedTest
	@ValueSource(strings = {"[1,5][3,6][7,2][3,6][4,4][5,3][17,3][4,5][8,1][2,8][10]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][11]",
		"[1,5][20,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][100,-3][4,5][8,1][2,8][10]"})
	public void over10(String test) {
		BowlingGame b = new BowlingGame(test);
		assertEquals(-1, b.getScore());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"[1,5][3,6][7,2][3,6][4,4][5,3][1,3,7][4,5][8,1][2,8][10]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10,0]",
		"[1,5][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][2,2]",
		"[1,5][3,6][7,2][3,6][4,4][5,3][1,1][4,5][8,1][2,8][3,3]"})
	public void extra(String test) {
		BowlingGame b = new BowlingGame(test);
		assertEquals(-1, b.getScore());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}