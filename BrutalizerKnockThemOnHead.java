import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class BrutalizerKnockThemOnHead implements MonsterAttack{
   public Party attack(Party heroParty){
      
      
      double wDamage = monsterPicksWeapon().getWeaponDamage();
       
      Collections.sort(heroParty.getHeroPartyList());
      Hero h = (Hero)heroParty.getHeroPartyList().get(0);
      System.out.println(h.getHeroName() + " hero health prior " + h.getHeroHealth()); 
        
       double newHeroHealth = h.getHeroHealth() - (3 + wDamage);
       h.setHeroHealth(newHeroHealth);
       System.out.println(h.getHeroName() + " hero health prior " + h.getHeroHealth()); 
       System.out.println("*******************************");
       
       if(h.getHeroHealth() <= 0){
          System.out.println(h.getHeroName() + " hero health <= 0: hero will now be removed from the party"); 
          System.out.println("*******************************");
          heroParty.removeHeroFromParty(h);
       }
       Collections.sort(heroParty.getHeroPartyList(), Collections.reverseOrder());
      return heroParty;
   }
   private Weapon monsterPicksWeapon(){
     Weapon weapon = null;
     Random rand = new Random(); 
     int weaponPick = rand.nextInt(2) + 1;
     
     if(weaponPick == 1){
        weapon = new WoodenClub();
     }
     else if(weaponPick == 2){
        weapon = new SpikeClub();
     }
     else if(weaponPick == 3){
        weapon = new DoubleHitWhammyClub();
     }  
     
     return weapon;
   }
}