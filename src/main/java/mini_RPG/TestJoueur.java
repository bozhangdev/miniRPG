package mini_RPG;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import junit.framework.TestCase;
import mini_RPG.joueur;
import mini_RPG.Printinformations;

public class TestJoueur extends TestCase {

	private joueur joueur;
	private Printinformations p = new Printinformations();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		joueur = new joueur("toto");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLevelup(){
		joueur.xp = 250;
		joueur.levelupp(p);
		assertEquals(2, joueur.level);
	}
	
	public void testUsepotion(){
		joueur.potion=0;
		joueur.usepotion(p);
		assertEquals(0, joueur.potion);
		joueur.potion=1;
		joueur.usepotion(p);
		assertEquals(0, joueur.potion);
	}
	
	public void testSleep(){
	    joueur.pv=10;
	    joueur.or=5;
	    joueur.sleep(p, joueur);
	    assertEquals(0, joueur.or);
	    assertEquals(15,joueur.pv);
	    joueur.pv=18;
	    joueur.or=5;
	    joueur.sleep(p, joueur);
	    assertEquals(3, joueur.or);
	    assertEquals(20, joueur.pv);
	}
	
	public void testBuypotion(){
		String input = "2";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		joueur.or=12;
		joueur.potion=0;
		joueur.buypotion(p, joueur);
		assertEquals(0, joueur.or);
		assertEquals(2, joueur.potion);
		String input1 = "5";
	    InputStream in1 = new ByteArrayInputStream(input1.getBytes());
	    System.setIn(in1);
	    joueur.or=5;
	    joueur.potion=0;
		joueur.buypotion(p, joueur);
		assertEquals(5, joueur.or);
		assertEquals(0, joueur.potion);
	}
	
	public void testLost(){
		joueur.xp=6;
		joueur.or=6;
		joueur.lost(p);	
		assertEquals(3, joueur.xp);
		assertEquals(3, joueur.or);
		assertEquals(0, joueur.pv);
	}
	
	public void testIflose(){
		joueur.pv=0;
		assertTrue(joueur.iflose(p));
	}
	
	public void testVictory(){
		monstre monstre=new monstre();
		monstre.xp=5;
		monstre.or=5;
		joueur.xp=4;
		joueur.or=3;
		joueur.victory(monstre, p);
		assertEquals(9, joueur.xp);
		assertEquals(8, joueur.or);
	}
	
	public void testReducepv(){
		monstre monstre=new monstre();
		monstre.attack=5;
		joueur.reducepvactual(monstre, p);
		assertEquals(15, joueur.pv);
	}
	
	public void testReducearmesactual(){
		monstre monstre=new monstre();
		monstre.reducearme=5;
		joueur.reducearmesactual(monstre, p);
		assertEquals(25, joueur.armesactuel);
	}
	
	public void testIfarmes(){
		joueur.armesactuel=-5;
		joueur.ifarmes();
		assertEquals(0, joueur.armesactuel);
	}
	

}
