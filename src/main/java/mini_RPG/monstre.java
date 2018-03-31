package mini_RPG;

public class monstre {
	
	public String name;
	protected int pvmax;
	public int pv;
	public int or;
	public int xp;
	public int attack;
	public int reducearme;//玩家攻击怪兽一次掉落的武器值
	
	
	public monstre(){
	}
	
	public String getnom(){
		return name;
	}
	
	public boolean iflose(){
		if(pv<=0){
			return true;
		}	
		else{
	    return false;
		}
	}
	
	public void afficherprofil(Printinformations p,monstre monstre)//在屏幕上显示怪兽的资料，名字、
	{
		p.printmonstreinfo(monstre);
	}
	
    public int getpvmaximun(){
    	return pvmax;
    }
    
    public int getpvactuel(){
    	return pv;
    }
    
	public int getor(){
		return or;
	}
	
	public int getxp(){
		return xp;
	}
	
	public int getlosearme(){
		return reducearme;
	}
	
	public void reducepv(joueur joueur,Printinformations p,monstre monstre)//怪兽被攻击后生命值减去玩家的攻击力
	{
		pv -= joueur.attack;
		joueur.armesactuel -= reducearme;
		if(this.pv < 0){
			pv = 0;
		}
		p.attackmonstre(monstre, joueur);
		
	}
}
