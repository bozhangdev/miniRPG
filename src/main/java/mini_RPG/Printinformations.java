package mini_RPG;

public class Printinformations {
	

	public void welcome(){
		System.out.println("****************************************");
    	System.out.println("Welcome to this game, what's your name?");
	}
	
	
	public void begingame(joueur joueur){
	System.out.println("Your name is " + joueur.name);
	System.out.println("Now the advance begins.");
	System.out.println("****************************************"+"\n");}
	
	
	public void menu(joueur joueur){//主菜单显示玩家信息
		System.out.println("****************************************");
		System.out.println("Name: "+"  "+joueur.name );
		System.out.println("LV: "+"    "+joueur.level);
		System.out.println("XP: "+"    "+joueur.xp +"/"+ joueur.xpmax);
		System.out.println("PV: "+"    "+joueur.pv + "/" + joueur.pvmax);
		System.out.println("Attack: "+joueur.attack);
		System.out.println("Armes: "+" "+joueur.armesactuel + "/" + joueur.armes);
		System.out.println("Or: "+"    "+joueur.or);
		System.out.println("Potion: "+joueur.potion);
		System.out.println("****************************************"+"\n");
	}
	
	
	public void fourchiox(){//主菜单选项
		System.out.println("-------------------------------------------");
		System.out.println("What do you want to do next?" + "\n" + "1. Fight 2. Sleep 3. Buy 4. Fix your armes");
	}
	
	
	public void threechiox(){//主菜单选项
		System.out.println("-------------------------------------------");
		System.out.println("What do you want to do next?" + "\n" + "2. Sleep 3. Buy 4. Fix your armes");
	}
	
	
	public void meetmonstre(monstre monstre){
		System.out.println("\nYou meet " + monstre.name);
	}
	
	
	public void printmonstreinfo(monstre monstre){
		System.out.println(monstre.name + "\n" + "PV: " + monstre.pv + "/" + monstre.pvmax + "\n"+ "Attack: " + monstre.attack + "\n");
	}
	
	
	public void fightchoix(){//玩家选择是否要攻击
		System.out.println("Do you want to fight with it?" + "\n" + "1. Yes 2. No");
	}
	
	public void escaped(){
		System.out.println("-------------------------------------------");
		System.out.println("You escaped.");
		System.out.println("-------------------------------------------"+"\n");
	}
	
	
	public void chioxinthegame(){//在游戏运行中，玩家选择是否攻击用药
		System.out.println("What do you want to do?" + "\n" + "1. Attack the monstre " + "2. Use potion");
	}
	
	
	public void attackedbymonstre(int pv, int pvmax, monstre monstre){
		System.out.println("You are attacked by " + monstre.name + ", you lost " + monstre.attack + " PV. You remain " + pv + "/" + pvmax + "." + "\n");
	}

	
	public void joueurreducearmes(monstre m){
		System.out.println("You have lost "+ m.reducearme+" armes");
	}
	
	
	public void attackmonstre(monstre monstre,joueur joueur){
		System.out.println("You attacked " + monstre.name + ", it reduced " + joueur.attack + " PV. Il remains " + monstre.pv + "/" + monstre.pvmax + ".");
	}
	
	
	public void havenopotion(){
	System.out.println("You don't have any potion.");
	System.out.println("-------------------------------------------"+"\n");}
	
	
	public void usedpotion(){
		System.out.println("You have used potion to recover.");
		System.out.println("-------------------------------------------"+"\n");
	}
	
	
	public void joueursuccess(){//成功函数
		System.out.println("-------------------------------------------");
		System.out.println("Congraduation! You won!");
		System.out.println("-------------------------------------------"+"\n");
	}
	
	
	public void levelup(){
	System.out.println("-------------------------------------------");
	System.out.println("Your level is up.");
	System.out.println("-------------------------------------------"+"\n");
	}
	
	
	public void joueurlose(){//失败函数
		System.out.println("Sorry, you have losed.");
		System.out.println("-------------------------------------------"+"\n");
	}
	

	public void printpotion(){
	System.out.println("The price of potion is $6, how many potions you want buy?");
	}
	
	
	public void havenomoneytobuypotion(){
	System.out.println("You don't have enough money.");
	System.out.println("-------------------------------------------"+"\n");
	}
	

	public void potion(int a){
		System.out.println("You have bought "+ a +" potion.");
		System.out.println("-------------------------------------------"+"\n");
	}

	
	public void howmanysleep(){
		System.out.println("How many PVs do you want to recover?");
	}
	
	
	public void sleepwell(joueur j){
		System.out.println("You have had a good dream!" + "\n" + "Now, your pv is " + j.pv + ".");
		System.out.println("-------------------------------------------"+"\n");
	}
	
	public void sleepnotwell(joueur j){
		System.out.println("Sorry, you don't have enough money to recover all the PVs you want. Now your PV is " + j.pv + "/" + j.pvmax + ".");
	}
	
	
	public void cantrepairarmes(int armesactuel, int armes){
	System.out.println("You don't have enough money to repair all the weapons you want. Now you have fixed " + armesactuel + "/" + armes + " armes." );
	System.out.println("-------------------------------------------"+"\n");}
	
	
	public void howmanyrepaireweapons(){
		System.out.println("How many armes do you want to repair?");
	}
	
	
	public void repaireweapons(){
	System.out.println("You have repaired all the weapons you want.");
	System.out.println("-------------------------------------------"+"\n");}
	

	public void inputwrongnumber(){
		System.out.println("You entered a wrong number, please enter the right number.");
	}

}
