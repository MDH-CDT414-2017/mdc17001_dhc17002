package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {


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
	@Test public void omitLast0() {     BowlingGame b = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0]");assertEquals(-1,b.getScore());  }
    @Test public void omitLast1() {     BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8]");assertEquals(-1,b.getScore());    }
    @Test public void omitLast2() {     BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0]");assertEquals(-1,b.getScore());   }
    @Test public void omitLast3() {     BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1]");assertEquals(-1,b.getScore()); }
   
    @Test public void omit0() {BowlingGame b = new BowlingGame("[1,5][7,2][3,6][4,4][5,3][3][4,5][8,1][10,0][7,2]");assertEquals(-1,b.getScore());  }
    @Test public void omit1() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][2,8][7]");assertEquals(-1,b.getScore());   }
    @Test public void omit2() {BowlingGame b = new BowlingGame("[3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");assertEquals(-1,b.getScore());  }
    @Test public void omit3() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][3][3,3][4,5][8,1][2,8][7]");assertEquals(-1,b.getScore());    }
   
    @Test public void negative0() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][-1,3][4,5][8,1][2,8][10]");assertEquals(-1, b.getScore());}
    @Test public void negative1() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][-10]");assertEquals(-1, b.getScore());}
    @Test public void negative2() {BowlingGame b = new BowlingGame("[1,5][-100,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");assertEquals(-1, b.getScore());}
    @Test public void negative3() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][-1,-3][4,5][8,1][2,8][10]");assertEquals(-1, b.getScore());}
    @Test public void negative4() {BowlingGame b = new BowlingGame("[5,-2][3,6][7,2][3,6][4,4][5,3][-1,-3][4,5][8,1][2,8][10]");assertEquals(-1, b.getScore());}
 
    @Test public void over100() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][17,3][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());  }
    @Test public void over101() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][11]");assertEquals(-1,b.getScore());   }
    @Test public void over102() {BowlingGame b = new BowlingGame("[1,5][20,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());  }
    @Test public void over103() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][100,-3][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());    }
    @Test public void over104() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][-2,50][5,3][100,-3][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());  }
   
    @Test public void extra0() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][1,3,7][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());  }
    @Test public void extra1() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10,0]");assertEquals(-1,b.getScore());  }
    @Test public void extra2() {BowlingGame b = new BowlingGame("[1,5][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][2,2]");assertEquals(-1,b.getScore());  }
    @Test public void extra3() {BowlingGame b = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][1,1][4,5][8,1][2,8][3,3]");assertEquals(-1,b.getScore());   }
 
    @Test public void strikeNext0() {BowlingGame b = new BowlingGame("[10,0][10,0][7,2][10,0][10,2][5,3][17,3][4,5][8,1][2,8][10]");assertEquals(-1,b.getScore());  }
    @Test public void strikeNext1() {BowlingGame b = new BowlingGame("[1,5][10,0][9,0][3,6][4,4][5,3][3,3][4,5][8,1][2,8][11]");assertEquals(-1,b.getScore());  }
    @Test public void strikeNext2() {BowlingGame b = new BowlingGame("[1,5][20,0][10,0][9,2][4,4][5,3][3,3][4,5][8,1][10,0][2]");assertEquals(-1,b.getScore()); }
    @Test public void strikeNext3() {BowlingGame b = new BowlingGame("[10,0][3,6][7,2][3,6][10,0][-1,-1][3,3][4,5][8,1][2,3]");assertEquals(-1,b.getScore());   }
    @Test public void strikeNext4() {BowlingGame b = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][2,8]");assertEquals(-1,b.getScore());  }

}
