public class CooperBowSpikes implements Weapon
{
   private double wHealth = 100;
   private double wDamage = 4.03;
   
   public double getWeaponHealth(){
      return 100;
   }
   public void setWeaponHealth(double wH){
      this.wHealth = wH;
   }
   public String getWeaponName(){
      return "CooperBowSpikes";
   }
   public double getWeaponDamage(){
      return 4.03;
   }
   public void setWeaponDamage(double wD){
      this.wDamage = wD;
   }

}