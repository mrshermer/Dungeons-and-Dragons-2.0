public class HeroBurnEffect extends HeroEffect{
   private double heroDamage = 0;
   private int effectTurn = 0;
   
   public HeroBurnEffect(double damage){
      this.heroDamage = damage;
   }  

   public Party performHeroEffect(Party heroP, Hero hero){
      System.out.println("You have been burned: Damage - " + heroDamage);
      System.out.println("*******************************");
      
      System.out.println(hero.getHeroName() + " health prior " + hero.getHeroHealth());
            
      if(effectTurn < 2){
         double newHeroHealth = hero.getHeroHealth() - heroDamage;
         hero.setHeroHealth(newHeroHealth);
         effectTurn++;
      }
      System.out.println(hero.getHeroName() + " health after " + hero.getHeroHealth());
      System.out.println("*******************************");

      if(hero.getHeroHealth() <= 0){
         System.out.println(hero.getHeroName() + " health <= 0: hero will now be removed from the party");
         System.out.println("*******************************");
  
         hero.getHeroEffects().clear();
         heroP.removeHeroFromParty(hero);
      }
      if(effectTurn >= 2){
         setHeroEffectOver(true);
      } 
      return heroP;
   }

}