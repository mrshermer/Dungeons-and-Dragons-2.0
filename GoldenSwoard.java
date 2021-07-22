public class GoldenSwoard implements Weapon{   
   private double weaponDamage = 3;
   private double weaponHealth = 100;    
     
   public double getWeaponDamage(){
     return 5;
   }
   public void setWeaponDamage(double wD){
     this.weaponDamage = wD;
   }
   public String getWeaponName(){
     return "Golden Swoard";
   }
   public double getWeaponHealth(){
     return 100;
   }
   public void setWeaponHealth(double wH){
     this.weaponHealth = wH;
   }
}