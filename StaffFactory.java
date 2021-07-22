public class StaffFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weapons = null;
      
      if(weapon.equals("Heal Staff")){
         weapons = new HealStaff();
      }
      else if(weapon.equals("Damage Staff")){
         weapons = new DamageStaff();  
      }
      else if(weapon.equals("StaffOfDestuction")){
         weapons = new StaffOfDestruction();
      }
      return weapons;
   }

}