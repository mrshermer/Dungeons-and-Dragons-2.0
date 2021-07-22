public class ClubFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weapons = null;
      
      if(weapon.equals("WoodenClub")){
         weapons = new WoodenClub();
      }
      else if(weapon.equals("SpikeClub")){
         weapons = new SpikeClub();  
      }
      else if(weapon.equals("DoubleHitWhammyClub")){
         weapons = new DoubleHitWhammyClub();
      }
      return weapons;
   }

}