public class BowGrappleHook implements Weapon
{
   private double wHealth = 100;
   private double wDamage = 6.08;
  
   public double getWeaponHealth(){
      return 100;
   }
   public void setWeaponHealth(double wH){
      this.wHealth = wH;
   }
   public String getWeaponName(){
      return "BowGrappleHook";
   }
   public double getWeaponDamage(){
      return 6.08;
   }
   public void setWeaponDamage(double wD){
      this.wDamage = wD;
   }
}