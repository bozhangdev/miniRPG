package mini_RPG;

import java.util.Scanner;

public class control {
	
	public monstre selectmonstre(joueur joueur){
		
		int x = 1;
		if(joueur.level<5){
			x=1+(int)(Math.random()*4);
		}
		if(joueur.level<10 && joueur.level>4){
			x=1+(int)(Math.random()*7);
		}
		monstre monstre = null;
		switch (x) {
		case 1:
			monstre =new monstre1();
			break;
		case 2:
			monstre =new monstre2();
			break;
		case 3:
			monstre =new monstre3();
			break;
		case 4:
		    monstre =new monstre4(); 
		    break;
		case 5:
			monstre = new monstre5();
			break;
		case 6:
			monstre = new monstre6();
			break;
		case 7:
			monstre = new monstre7();
			break;
		default:
			break;
		}
		return monstre;
	}
	
	
	public void diff(String a, joueur joueur, monstre monstre,Printinformations p){
		switch (a){
		case "1":
			iffight(joueur, monstre, p);
			break;
		case "2":
			joueur.sleep(p, joueur);
			break;
		case "3":
			joueur.buypotion(p, joueur);
			break;
		case "4":
			joueur.repairearmes(p);
			break;
		}
	}

	
	public void iffight(joueur joueur, monstre monstre,Printinformations p){
		p.meetmonstre(monstre);
		p.printmonstreinfo(monstre);
		p.fightchoix();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		while(a.replaceAll("[1-2]","").length()!=0 || a.length()!=1){
			p.inputwrongnumber();
			a = sc.nextLine();
		}
		switch (a){
		case "1":
			combat(joueur, monstre, p);
			break;
		case "2":
			p.escaped();
			break;
		}
	}
	
	public void progress(joueur joueur,Printinformations p){
		p.menu(joueur);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choose;
		if(joueur.pv == 0 || joueur.armesactuel == 0){
			p.threechiox();
			choose = sc.nextLine();
			while(choose.replaceAll("[2-4]","").length()!=0 || choose.length()!=1){
				p.inputwrongnumber();
				choose = sc.nextLine();
		}
		}
		else{
			p.fourchiox();
			choose = sc.nextLine();
			while(choose.replaceAll("[1-4]","").length()!=0 || choose.length()!=1){
			p.inputwrongnumber();
			choose = sc.nextLine();
			}
		}
		monstre monstre=null;
		monstre=selectmonstre(joueur);
		diff(choose, joueur, monstre, p);
		try {
		       Thread.sleep (2000) ; 
		 } catch (InterruptedException ie){
		 }
	}
	
	public void combat(joueur joueur, monstre monstre,Printinformations p){
		if(joueur.attack >= monstre.attack){
			joueurattackfirst(joueur, monstre, p);
		}
		else{
			monstreattackfirst(joueur, monstre, p);
		}
	}
	
	public void joueurattackfirst(joueur joueur, monstre monstre,Printinformations p){
		while(joueur.pv>0 && monstre.pv>0){
			p.chioxinthegame();
			//
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
			while(a.replaceAll("[1-2]","").length()!=0 || a.length()!=1){
				p.inputwrongnumber();
				a = sc.nextLine();
			}
			switch(a){
			case "1":
				monstre.reducepv(joueur, p, monstre);
				if(monstre.iflose()){
					joueur.victory(monstre, p);
					joueur.levelupp(p);
					break;
				}
				joueur.reducepvactual(monstre, p);
				if(joueur.iflose(p)){
					joueur.lost(p);
				}
				break;
			case "2":
				joueur.usepotion(p);
				joueur.reducepvactual(monstre, p);
				if(joueur.iflose(p)){
					joueur.lost(p);
				}
				break;
			}
		}
	}
	
	public void monstreattackfirst(joueur joueur, monstre monstre,Printinformations p){
		while(joueur.pv>0 && monstre.pv>0){
			joueur.reducepvactual(monstre, p);
			if(joueur.iflose(p)){
				joueur.lost(p);
				break;
			}
			p.chioxinthegame();
			//
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
			while(a.replaceAll("[1-2]","").length()!=0 || a.length()!=1){
				p.inputwrongnumber();
				a = sc.nextLine();
			}
			switch(a){
			case "1":
				monstre.reducepv(joueur, p, monstre);
				if(monstre.iflose()){
					joueur.victory(monstre, p);
					joueur.levelupp(p);
				}
				break;
			case "2":
				joueur.usepotion(p);
				break;
		}
		
	}
	}
}
