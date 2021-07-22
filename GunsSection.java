import java.util.HashMap;
import java.util.Map;

public class GunsSection extends Store{
   private HashMap<String, GunsSection> mapGunsSection = new HashMap<String, GunsSection>();
   private Store store = null;
   private GunFactory gS = null;
   private Weapon weapon = null;
   
   
   public GunsSection(){
      
   }
  
   public GunsSection(int wL, int wC, boolean wLInd, boolean wA, String wAH){
         weaponLevel = wL;
         weaponCost = wC;
         weaponLevelInd = wLInd;
         weaponAvaibilty = wA;
         weaponApplyHero = wAH; 
   }
   public void addWeapons(){
      mapGunsSection.put("Sniper", new GunsSection(1, 5, true, true, "Marksmen"));
      mapGunsSection.put("Musket", new GunsSection(1, 10, true, true, "Marksmen"));
      mapGunsSection.put("Machine Gun", new GunsSection(1, 15, true, true, "Marksmen"));
   }
   public void setStoreVarible(Store s){
      this.store = s;
   }
   public Store getStore(){
      return store;
   }
   
   public GunsSection returnWeaponStats(String weapon){
      GunsSection gunsSec = mapGunsSection.get(weapon);
      return gunsSec;
   }
   public boolean doesWeaponExists(String weapon){
      return mapGunsSection.containsKey(weapon);
   }
   public void applyStats(String weapon){
      mapGunsSection.put(weapon, new GunsSection(store.getWeaponLevel(), 
      store.getWeaponCost(), store.getWeaponLevelInd(), store.getWeaponAvaibility(), store.getWeaponApplyHero()));
   }
   public void listWeapons(){
       System.out.println("---------------------------");
       GunsSection gunsSec = null;
       gS = new GunFactory();
       
       for(Map.Entry<String, GunsSection> mapElement: mapGunsSection.entrySet()){
          String weaponName =  mapElement.getKey();
          gunsSec = mapElement.getValue();
          weapon = gS.createWeapon(weaponName);
          
          System.out.println(weaponName + "\nWeapon Cost: " + gunsSec.getWeaponCost() + 
          "\nWeapon Damage: " + weapon.getWeaponDamage() + "\nWeapon Avaibility: " + gunsSec.getWeaponAvaibility() +
          "\nHeroWeaponCategory: " + gunsSec.getWeaponApplyHero());  
          System.out.println("*******************************");
          System.out.println();
       }
       System.out.println("---------------------------");
   }
   public void levelUpWeapons(){
      gS = new GunFactory();
      
      for(Map.Entry mapElement: mapGunsSection.entrySet()){
           String weaponName = (String) mapElement.getKey();
           GunsSection sSec = (GunsSection)mapElement.getValue();
           Weapon weapon = gS.createWeapon(weaponName);
           
           if(sSec.getWeaponLevel() == 1 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1);
               
           }
           else if(sSec.getWeaponLevel() == 2 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 1.5);
           }
           else if(sSec.getWeaponLevel() == 3 && sSec.getWeaponAvaibility()){
               weapon.setWeaponDamage(weapon.getWeaponDamage() + 2);
           }
           mapGunsSection.put(weaponName, new GunsSection(weaponLevel+1, sSec.getWeaponCost(), sSec.getWeaponLevelInd(), 
           sSec.getWeaponAvaibility(), sSec.getWeaponApplyHero()));
        }
   }
   public boolean doesStoreHaveWeaponsHero(Hero h){
      boolean valid = false;
      GunsSection sSec = null;
      
      for(Map.Entry<String, GunsSection> mapElement: mapGunsSection.entrySet()){
         sSec = mapElement.getValue();
         
         if(sSec.getWeaponApplyHero().equals(h.getHeroName()) && sSec.getWeaponAvaibility()
         && sSec.getWeaponCost() <= h.getHeroGold()){
            valid = true;
         }
      }
      return valid;
   }

}