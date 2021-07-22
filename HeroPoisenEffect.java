public class HeroPoisenEffect extends HeroEffect{
   private int poisenTurn = 0;
   private double damage = 0;
   
   public HeroPoisenEffect(double damage){
     this.damage = damage;
   }  
   
   public Party performHeroEffect(Party hP, Hero h){
      System.out.println("Poisen Effect: Damage - " + damage); 
      System.out.println("*******************************");
      
      System.out.println(h.getHeroName() + " health prior: " + h.getHeroHealth());
      
      if(poisenTurn < 2){
         h.setHeroHealth(h.getHeroHealth() - damage);
         poisenTurn++;
      }
      System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
      System.out.println("*******************************");
      
      if(poisenTurn >= 2){
         setHeroEffectOver(true);
      }
      if(h.getHeroHealth() <= 0){
         System.out.println(h.getHeroName() + " health is <= 0: hero will now be removed from the party");
         System.out.println("*******************************");
         h.getHeroEffects().clear();
         hP.removeHeroFromParty(h);
      }
      return hP;
   }
}