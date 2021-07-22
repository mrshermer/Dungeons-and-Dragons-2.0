public class HeroDeciderFactory{

   public Hero createHero(String hero){
      Hero h = null;
      
      if(hero.toUpperCase().equals("MAGE")){
         h = new Mage();
      }
      else if(hero.toUpperCase().equals("ROBOT")){
         h = new Robot();
      }
      else if(hero.toUpperCase().equals("HEALER")){
         h = new Healer();
      }
      else if(hero.toUpperCase().equals("SORECOR")){
         h = new Sorecor();
      }
      else if(hero.toUpperCase().equals("MARKSMEN")){
         h = new Marksmen();
      }
      return h;
   }



}