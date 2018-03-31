package mini_RPG;

import java.util.Scanner;

public class joueur {
	public String name;
	public int pvmax=20;
	public int pv=20;
	public int attack=5;
	public int armes=30;
	public int armesactuel=30;
	public int xp=0;
	public int xpmax=20;
	public int or=20;
	public int level=1;
	public int potion=2;
		
	public joueur(String a){
	    name = a;
	}
	
	public void repairearmes(Printinformations p){//修武器
		String a;
		int c = armes-armesactuel;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		p.howmanyrepaireweapons();
		a = sc.nextLine();
		while(a.replaceAll("[0-9]","").length()!=0){
			p.inputwrongnumber();
			a = sc.nextLine();
		}
		int b = Integer.parseInt(a);
		if(b>c){
			b=c;
		}
		if(b>or){
			armesactuel+=or;
			or=0;
			p.cantrepairarmes(armesactuel, armes);
		}
		else{
			armesactuel+=b;
			or-=b;
			p.repaireweapons();
		}
	}
	
    public void levelupp(Printinformations p){
    	 if(xp>=xpmax){
 			level++;
 			attack+=3;
 			xp-=xpmax;
 			xpmax=xpmax+4;
 			pvmax+=5;
 			pv+=5;
 			armes+=2;
 			p.levelup();}
     }
	
	 public void usepotion(Printinformations p){//使用药水恢复生命值
		if(potion==0){
			p.havenopotion();
		}
		else{
			potion--;
			pv=(int) (pv + Math.round(pvmax*0.6));
			p.usedpotion();
			if(pv>pvmax){
				pv=pvmax;
			}
		}
	}
	
	public void sleep(Printinformations p, joueur j){//在小旅馆睡觉
		String a;
		int c = pvmax -pv;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		p.howmanysleep();
		a = sc.nextLine();
		while(a.replaceAll("[0-9]","").length()!=0){
			p.inputwrongnumber();
			a = sc.nextLine();
		}
		int b = Integer.parseInt(a);
		if(b>c){
			b=c;
		}
		if(or<b){
			pv+=or;
			or=0;
			p.sleepnotwell(j);
		}
		else{
			pv+=b;
			or-=b;
			p.sleepwell(j);
		}
	}
	
	public void buypotion(Printinformations p,joueur joueur){//购买药水
		int a = 0;
		p.printpotion();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		if(or>=6*a){
			or-=6*a;
			potion+=a;
			p.potion(a);
		}
		else{
			p.havenomoneytobuypotion();
		}
	}
	
	public void lost(Printinformations p){//失败函数,减经验，减金钱
		xp=Math.round(xp/2);
		or=Math.round(or/2);
		pv = 0;
		p.joueurlose();
		ifarmes();
	}
	
	public boolean iflose(Printinformations p){
		if(pv<=0){
			return true;
		}	
		else{
	    return false;
		}
	}

	public void victory(monstre monstre,Printinformations p){//胜利函数，加经验，加金钱
		xp+=monstre.xp;
		or+=monstre.or;
		p.joueursuccess();
		ifarmes();
	}
	
	
	public void inputname(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
	}
	

	public void reducepvactual(monstre monstre, Printinformations p){
		pv-= monstre.attack;
		if(pv < 0){
			pv = 0;
		}
		p.attackedbymonstre(pv, pvmax, monstre);
	}
	
	public void reducearmesactual(monstre monstre,Printinformations p){
		armesactuel -= monstre.reducearme;
		pv-=monstre.attack;
		p.joueurreducearmes(monstre);
	}
	
	public void ifarmes(){
		if(armesactuel < 0){
			armesactuel = 0;
		}
	}
}


	
	