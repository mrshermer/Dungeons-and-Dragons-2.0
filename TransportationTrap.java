public class TransportationTrap extends Traps{
   public void performTrapEffect(int currentUserR, int currentUserC, Object[][] maze){
      
      setUserRow(currentUserR);
      setUserCol(currentUserC);
      
      for(int a = 1; a < 9; a++){
         for(int b = 1; b < 20; b++){
            if(maze[a][b] instanceof Traps)
               if(a == currentUserR && b != currentUserC){
                  setUserRow(a);
                  setUserCol(b);
                  b = 20;
                  a = 9;
               }
               else if(a != currentUserR && b != currentUserC){
                  setUserRow(a);
                  setUserCol(b);
                  b = 20;
                  a = 9;
               }
               
            }
         }
      
      
   } 
   public void trapDescription(){
      System.out.println("Welcome to the transportation trap, you will be transporated to another trap, sorry:(");
      System.out.println("*******************************");
   }

}