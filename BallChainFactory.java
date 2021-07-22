public class BallChainFactory implements WeaponAbstractFactory{
   public Weapon createWeapon(String weapon){
      Weapon weapons = null;
      
      if(weapon.equals("Ball Chain")){
         weapons = new BallChain();
      }
      else if(weapon.equals("BallSpikesChain")){
         weapons = new BallWithSpikes();  
      }
      else if(weapon.equals("SteelBallChain")){
         weapons = new SteelBall();
      }
      return weapons;
   }

}