public class BowFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weaponBow = null;
      
      if(weapon.equals("Wooden Bow")){
         weaponBow = new WoodenBow();
      }
      else if(weapon.equals("CooperBowSpikes")){
         weaponBow = new CooperBowSpikes();  
      }
      else if(weapon.equals("BowGrappleHook")){
         weaponBow = new BowGrappleHook();
      }      
      return weaponBow;
   }
}