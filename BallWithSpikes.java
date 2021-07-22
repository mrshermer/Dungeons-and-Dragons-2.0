public class BallWithSpikes implements Weapon
{
   private double wHealth = 100;
   private double wDamage = 4;
   
   public double getWeaponHealth(){
      return wHealth;
   }
   public void setWeaponHealth(double wH){
      this.wHealth = wH;
   }
   public String getWeaponName(){
      return "BallSpikesChain";
   }
   public double getWeaponDamage(){
      return wDamage;
   }
   public void setWeaponDamage(double wD){
      this.wDamage = wD;
   }
}
