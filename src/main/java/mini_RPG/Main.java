package mini_RPG;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int i=1;
		joueur joueur = new joueur("a");
		control control = new control();
		Printinformations p=new Printinformations();
        p.welcome();
    	joueur.inputname();
    	p.begingame(joueur);
    	for (i=1;i<100000;i++){
    		control.progress(joueur, p);
    	}
    }
}
