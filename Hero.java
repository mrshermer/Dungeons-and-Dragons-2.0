import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero {
    protected ArrayList<Weapon> heroWeapons = new ArrayList<Weapon>();
    private ArrayList<HeroEffect> heroEfects = new ArrayList<HeroEffect>();
    HeroAttacks attackMove = null;
    private boolean heroImmobilized = false;
    private double heroHealth = 100;
    private int heroGold = 10;
    private int heroTurn = 0;
    
    public ArrayList<Monster> perfomHeroAttack(Party heroParty, ArrayList<Monster> m, Weapon weapon){
        m = attackMove.heroAttack(heroParty.getHeroPartyList(), m, weapon);
        return m;
    }
    public abstract void decideAttackMove();
    public abstract String getHeroName();
    
    public void setHeroImmobolized(boolean hI){
       this.heroImmobilized = hI;
    }
    public boolean getHeroImmobilized(){
       return heroImmobilized;
    }
    public void setHeroWeapons(ArrayList<Weapon> hW){
       this.heroWeapons = hW;
    }
    public void addHeroWeapons(Weapon w){
      heroWeapons.add(w);
    }
    public Weapon removeWeapons(){
       Scanner scan = new Scanner(System.in);
       int a = 0;
       
       System.out.println("Please indicate the weapon you would like to remove");
       System.out.println("*******************************");
       
       for(a = 0; a < heroWeapons.size(); a++){
         System.out.println(a + ") " + heroWeapons.get(a).getWeaponName());
       }
       int userChoice = scan.nextInt();
       while(userChoice >= heroWeapons.size()){
         System.out.println("I'm sorry, please indicate a valid weapon");
         for(a = 0; a < heroWeapons.size(); a++){
               System.out.println(a + ") " + heroWeapons.get(a).getWeaponName());
         }
         System.out.println("*******************************");
         userChoice = scan.nextInt();
       }
       Weapon weapon = heroWeapons.get(userChoice);       
       heroWeapons.remove(userChoice);
       return weapon;
    }
    public ArrayList<Weapon> getWeaponSet(){
       return heroWeapons;
    }
    public double getHeroHealth(){
       return heroHealth;
    }
    public void setHeroHealth(double health){
       this.heroHealth = health;
    }
    public int getHeroGold(){
       return heroGold;
    }
    public void setHeroGold(int hG){
       this.heroGold = hG;
    }
    public ArrayList<HeroEffect> getHeroEffects(){
       return heroEfects;
    }
    public void addToHeroEffects(HeroEffect h){
       heroEfects.add(h);
    }
    public void removeHeroEffects(int effectIndex){
       heroEfects.remove(effectIndex);
    }
    public void clearHeroEffects(){
       heroEfects.clear();
    }
    public int getHeroTurn(){
       return heroTurn;
    }
    public void setHeroTurn(int hT){
      this.heroTurn = hT;
    }
    public void listHeroWeapons(){
       System.out.println(getHeroName() + " your current list of weapons");
       System.out.println("*******************************");
       
       for(int a = 0; a < heroWeapons.size(); a++){
         System.out.println("Weapon: " + heroWeapons.get(a).getWeaponName() + " " + 
         "\nWeapon Health: " + heroWeapons.get(a).getWeaponHealth() + 
         "\nWeapon Damage: " + heroWeapons.get(a).getWeaponDamage());
         
         if(heroWeapons.get(a).getWeaponHealth() > 0){
            System.out.println("\nWeapon Status: Can be used in battle, weapon health > 0");
            System.out.println("*******************************");
         }
         else if(heroWeapons.get(a).getWeaponHealth() <= 0){
            System.out.println("\nWeapon Status: Can't be used in battle, weapon health <= 0");
            System.out.println("*******************************");
         }
       }  
    }
    public boolean weaponsAvaibleOnHeroBelt(){
       boolean valid = false;
       
       for(int a = 0; a < heroWeapons.size(); a++){
          if(heroWeapons.get(a).getWeaponHealth() > 0){
            valid = true;
          }
       }
       return valid;
    }
     
}