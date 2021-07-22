public class SwoardFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weapons = null;
      
      if(weapon.equals("Bronze Swoard")){
         weapons = new BronzeSwoard();
      }
      else if(weapon.equals("Silver Swoard")){
         weapons = new SilverSwoard();  
      }
      else if(weapon.equals("Golden Swoard")){
         weapons = new GoldenSwoard();
      }
      return weapons;
   }

}