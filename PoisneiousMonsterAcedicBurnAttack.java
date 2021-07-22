import java.util.ArrayList;
import java.util.Random;

public class PoisneiousMonsterAcedicBurnAttack implements MonsterAttack{
   public Party attack(Party hParty){
      Hero hero = null;
      hero = pickHero(hParty);
      Random wRandom = new Random();
      
      System.out.println(hero.getHeroName() + " health prior: " + hero.getHeroHealth());
       
      if(hero.getWeaponSet().size() != 0){
         int monsterPickWeapon = wRandom.nextInt(hero.getWeaponSet().size());
         
         Weapon weapon = hero.getWeaponSet().get(monsterPickWeapon);
         
         if(weapon.getWeaponHealth() > 0){
            weapon.setWeaponHealth(weapon.getWeaponHealth() - 5);
         }
      }
      hero.setHeroHealth(hero.getHeroHealth() - 3);
      
      System.out.println(hero.getHeroName() + " health after: " + hero.getHeroHealth());
      System.out.println("*******************************");
      
      if(hero.getHeroHealth() <= 0){
         System.out.println(hero.getHeroName() + " health <= 0, the hero will now be removed from the party ");
         System.out.println("*******************************");
         hParty.removeHeroFromParty(hero);
      }
      return hParty;
   }
   private Hero pickHero(Party hParty){
      Hero hero = null;
      Random rand = new Random();
      int monsterChoice = rand.nextInt(hParty.getHeroPartyList().size());
      
      for(int a = 0; a < hParty.getHeroPartyList().size(); a++){
        if(a == monsterChoice){
           hero = (Hero)hParty.getHeroPartyList().get(a);
        }
      }
      
      return hero;
   }

}