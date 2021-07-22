public abstract class HeroEffect{
   private boolean heroEffectOver = false;
   
   public abstract Party performHeroEffect(Party hParty, Hero h);
   
   public void setHeroEffectOver(boolean hF){
      this.heroEffectOver = hF;
   }
   public boolean getHeroEffectOver(){
      return heroEffectOver;
   }

}