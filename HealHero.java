import java.util.ArrayList;
import java.util.Scanner;

public class HealHero implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> monster, Weapon w){
      int newHeroHealth = 0;
      
      if(w!= null){
         newHeroHealth = 10 + (int)w.getWeaponDamage();      
      }
      else{
         newHeroHealth = 10;
      }
      int heroToHeal = chooseHeroToHeal(hero, newHeroHealth);
      if(heroToHeal <= hero.size()){
         Hero h = hero.get(heroToHeal);
         System.out.println(h.getHeroName() + " health prior: " + h.getHeroHealth());
         h.setHeroHealth(h.getHeroHealth() + newHeroHealth);
         System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
         System.out.println("*******************************");
      }     
   
      return monster;
   }
   private int chooseHeroToHeal(ArrayList<Hero> hero, int newHeroHealth){
      System.out.println("Please choose the hero's in your party to heal");
      System.out.println("If no heros are avaible to heal, press 5)");
      Scanner scan = new Scanner(System.in);
      int a = 0;
      int userChoice = 0, healOnce = 0;
      
      do{
      
         for(a = 0; a < hero.size(); a++){
            System.out.println(a + ") " + hero.get(a).getHeroName() + " Health: " + hero.get(a).getHeroHealth());
         }
         System.out.println("*******************************");
         userChoice = scan.nextInt();
             
         if(userChoice < hero.size()){
               if(hero.get(userChoice).getHeroHealth() + newHeroHealth > 100){
                  System.out.println("I'm sorry, if you heal this hero it will be over the maximum health - 100, " +
                  "\nplease choose another hero to heal");
                  System.out.println("Please choose the hero's in your party to heal");
                  System.out.println("If no heros are avaible to heal, press 5)");
               }
               else {
                  healOnce = 1;
               }
         }      
         
         
      }while(userChoice != 5 && healOnce == 0);
      
      return userChoice;
   }
}