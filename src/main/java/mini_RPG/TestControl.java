package mini_RPG;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import junit.framework.TestCase;
import mini_RPG.joueur;
import mini_RPG.monstre1;
import mini_RPG.Printinformations;

public class TestControl extends TestCase {

	joueur joueur;
	Printinformations p = new Printinformations();
	control control = new control();
	monstre monstre;
	
	protected void setUp() throws Exception {
		super.setUp();
		joueur = new joueur("zz");;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testJoueurattackfirst(){
		monstre = new monstre1();
		String input = "1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    	System.setIn(in);
	    control.joueurattackfirst(joueur, monstre, p);
	}
}
