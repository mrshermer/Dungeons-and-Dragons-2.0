public class BronzeSwoard implements Weapon
{
   private double weaponDamage = 1;
   private double weaponHealth = 100;
   
   public double getWeaponDamage(){
     return weaponDamage;
   }
   public void setWeaponDamage(double wD){
     this.weaponDamage = wD;
   }
   public String getWeaponName(){
     return "Bronze Swoard";
   }
   public double getWeaponHealth(){
     return weaponHealth;
   }
   public void setWeaponHealth(double wH){
     this.weaponHealth = wH;
   }
}