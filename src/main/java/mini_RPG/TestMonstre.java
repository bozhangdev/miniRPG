package mini_RPG;

import junit.framework.TestCase;
import mini_RPG.joueur;
import mini_RPG.monstre;
import mini_RPG.Printinformations;

public class TestMonstre extends TestCase {

	monstre monstre;
	Printinformations p=new Printinformations();
	
	protected void setUp() throws Exception {
		super.setUp();
		monstre = new monstre1();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testReducepv(){
		joueur joueur=new joueur("ww");
		monstre.reducepv(joueur, p, monstre);
		assertEquals(5, monstre.pv);
	}

	public void testIflose(){
		monstre.pv=0;
		assertTrue(monstre.iflose());
	}
}
