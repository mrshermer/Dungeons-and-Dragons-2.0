public class SilverSwoard implements Weapon{   
   
   private double weaponDamage = 3;
   private double weaponHealth = 100;  
     
   public double getWeaponDamage(){
     return weaponDamage;
   }
   public void setWeaponDamage(double wD){
     this.weaponDamage = wD;
   }
   public String getWeaponName(){
     return "Silver Swoard";
   }
   public double getWeaponHealth(){
     return weaponHealth;
   }
   public void setWeaponHealth(double wH){
     this.weaponHealth = wH;
   }
}   