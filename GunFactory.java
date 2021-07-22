public class GunFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weapons = null;
      
      if(weapon.equals("Sniper")){
         weapons = new Sniper();
      }
      else if(weapon.equals("Musket")){
         weapons = new Musket();  
      }
      else if(weapon.equals("Machine Gun")){
         weapons = new MachineGun();
      }
      return weapons;
   }



}