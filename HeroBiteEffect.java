public class HeroBiteEffect extends HeroEffect{
   private int effectTurn = 0;
   private double damage = 0; 
   
   public HeroBiteEffect(double damage){
      this.damage = damage;
   }
   
   public Party performHeroEffect(Party hParty, Hero h){
      System.out.println("Oh no, you have been bitten: Damage - " + damage);
      System.out.println("*******************************");
   
      System.out.println(h.getHeroName() + " health prior: " + h.getHeroHealth());
      
      if(effectTurn < 2){
         double newHeroHealth = h.getHeroHealth() - this.damage;
         h.setHeroHealth(newHeroHealth);
         
         effectTurn++;
      }
      System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
      System.out.println("*******************************");
      
      if(h.getHeroHealth() <= 0){
         System.out.println(h.getHeroName() + " health <= 0: hero will now be removed from the party");
         System.out.println("*******************************");

         h.getHeroEffects().clear();
         hParty.removeHeroFromParty(h);
      }
      if(effectTurn >= 2){
         setHeroEffectOver(true);
      }
      return hParty;
   }  

}