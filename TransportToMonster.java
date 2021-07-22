import java.util.ArrayList;

public class TransportToMonster extends Traps{
   public void performTrapEffect(int currRow, int currCol, Object[][] maze){
      
      setUserRow(currRow);
      setUserCol(currCol);
                
       for(int a = 1; a< 9; a++){
          for(int b = 1; b < 20; b++){
             if(maze[a][b] instanceof ArrayList<?>){
                 setUserCol(b);    
                 setUserRow(a);
                 return;
             }
          }
       }
   
   }
   public void trapDescription(){
      System.out.println("Welcome to the transportation trap, you will be transporated to a monster, sorry:(");
      System.out.println("*******************************");
   }

}