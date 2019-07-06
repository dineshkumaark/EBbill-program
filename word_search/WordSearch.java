import java.util.*;
public class WordSearch {
     static boolean exist(char[][] board, String word) {
        boolean found = false;
        for(int i = 0; i < board.length;i++){
        for(int j = 0; j < board[i].length;j++){
            if(board[i][j] == word.charAt(0)){
                found = isexist(board,word,i,j,0);
                if(!found){
                   continue;
                }
            return found;
          }
        }
      }
        return false;
    }
    static boolean isexist(char[][] grid,String word,int i,int j,int count){
      if(count == word.length()){
        return true;
        }
      if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != word.charAt(count)){
        return false;
        }
      if(grid[i][j] == word.charAt(count)){
        count++;
        }
    char temp = grid[i][j];
    grid[i][j] = ' ';
      boolean isFound = isexist(grid,word,i+1,j,count) || isexist(grid,word,i,j+1,count) || isexist(grid,word,i-1,j,count) || isexist(grid,word,i,j-1,count);
      grid[i][j] = temp;
      return isFound;      
      }
    public static void main(String[] args) {
    // char[][] grid = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    // String word = "SEE";
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    char[][] grid = new char[size][size];
    for(int i = 0; i < size;i++){
        for(int j = 0; j < size;j++){
            grid[i][j] = sc.next().charAt(0);
        }
    }
    System.out.println("Enter the Word");
    String word = sc.next();
    boolean found = exist(grid,word);
    System.out.println(found);
    }
}