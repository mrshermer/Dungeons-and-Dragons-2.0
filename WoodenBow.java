public class WoodenBow implements Weapon{
   private double wDamage = 2.01;
   private double wHealth = 100;
   
   public double getWeaponDamage(){
     return wDamage;
   }
   public void setWeaponDamage(double wD){
     this.wDamage = wD;
   }
   public String getWeaponName(){
     return "Wooden Bow";
   }
   public double getWeaponHealth(){
     return wHealth;
   }
   public void setWeaponHealth(double wH){
     this.wHealth = wH;
   }
}