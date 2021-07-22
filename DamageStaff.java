public class DamageStaff implements Weapon
{
   private double wDamage = 5;
   private double wHealth = 100;
   
   public double getWeaponHealth(){
     return wHealth;
   }
   public void setWeaponHealth(double wH){
      this.wHealth = wH;
   }
   public String getWeaponName(){
     return "Damage Staff";
   }
   public double getWeaponDamage(){
     return wDamage;
   }
   public void setWeaponDamage(double wD){
     this.wDamage = wD;
   }
}