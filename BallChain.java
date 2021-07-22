public class BallChain implements Weapon
{
   private double wHealth = 100;
   private double wDamage = 2;
   
   public double getWeaponHealth(){
      return wHealth;
   }
   public void setWeaponHealth(double wH){
      this.wHealth = wH;
   }
   public String getWeaponName(){
      return "Ball Chain";
   }
   public double getWeaponDamage(){
      return wDamage;
   }
   public void setWeaponDamage(double wD){
      this.wDamage = wD;
   }
}