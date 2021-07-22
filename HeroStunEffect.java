public class HeroStunEffect extends HeroEffect{

   private int stunTurn = 0;

   public Party performHeroEffect(Party hP, Hero h){
      
      
      if(stunTurn < 1 && !h.getHeroImmobilized()){
         System.out.println("You are now stunned for 1 turn");
         System.out.println("**************************");
         
         h.setHeroImmobolized(true);
         stunTurn++;
      }
      else if(stunTurn == 1 && h.getHeroImmobilized()){
         h.setHeroImmobolized(false);
         setHeroEffectOver(true);
      }
      return hP;
  }

}