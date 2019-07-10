import java.util.*;
public class MinMatrix {
  static ArrayList<String> al = new ArrayList<>();
  //Declaring Four Corners
  static boolean topleft =  false;
  static boolean topright =  false;
  static boolean botleft = false;
  static boolean botright = false;
  static int index1 = 0;
  static int index2 = 0;

  static int solveLand(int[][] land,int i,int j){
    // Checking Corners are Valid  
      topleft = (land[0][0] == 1) ? true : false;
      topright = (land[0][land[0].length-1] == 1)? true : false;
      botleft = (land[land.length-1][0] == 1)?true:false;
      botright = (land[land.length-1][land[0].length-1] == 1)?true:false;
      
    if((i == 0 && j== 0)||(i==0 && j==land[0].length-1)|| (i==land.length-1 && j== 0) || (i==land.length-1 && j == land[0].length-1)){
      return 0;
      }else{
        return findCorner(land,i,j,0);
        }
    }
    static int findCorner(int[][] land,int i,int j,int count){
      if((i == 0 && j== 0)||(i==0 && j==land[0].length-1)|| (i==land.length-1 && j== 0) || (i==land.length-1 && j == land[0].length-1)){
          al.add(count+"="+i+"i"+j+"j");
          if( i == 0 && j == 0){
              topleft = false;
              findCorner(land,index1,index2,0);
          }
          if( i == 0 && j == land[0].length-1){
              topright = false;
              findCorner(land,index1,index2,0);
          }
          if( i == land.length-1 && j == 0){
              botleft = false;
              findCorner(land,index1,index2,0);
          }
          if( i == land.length-1 && j == land[0].length-1){
              botright = false;
              findCorner(land,index1,index2,0);
          }
        }
    //Bottom Right
    if(botright){
        if(isSafe(land,i+1,j)){
         return findCorner(land,i+1,j,count+1);
        }else if(isSafe(land,i,j+1)){
         return findCorner(land,i,j+1,count+1);
        }else{
            botright = false;
            findCorner(land,index1,index2,0);
        }
    }
    //Bottom Left
    if(botleft){
      if(isSafe(land,i+1,j)){
         return findCorner(land,i+1,j,count+1);
        }else if(isSafe(land,i,j-1)){
         return findCorner(land,i,j-1,count+1);
        }else{
            botleft = false;
            findCorner(land,index1,index2,0);
        }
    }
     //topright
    if(topright){
      if(isSafe(land,i-1,j)){
         return findCorner(land,i-1,j,count+1);
        }else if(isSafe(land,i,j+1)){
         return findCorner(land,i,j+1,count+1);
        }else{
            topright = false;
            findCorner(land,index1,index2,0);
        }
    }
     //topleft
     if(topleft){
      if(isSafe(land,i-1,j)){
         return findCorner(land,i-1,j,count+1);
        }else if(isSafe(land,i,j-1)){
         return findCorner(land,i,j-1,count+1);
        }else{
            topleft = false;
            findCorner(land,index1,index2,0);
        }
      }
        return count;
      }
      static boolean isSafe(int[][] land,int i,int j) {
        if(i < 0 || i > land.length-1 || j < 0 || j > land[0].length-1 || land[i][j] == 0 || land[i][j] != 1){
         return false;
        }
        return true;
        }
    public static void main(String[] args) {
      int[][] land = {{1,0,0,1},{1,1,2,0},{0,1,0,0},{1,1,1,0}};
       index1 = 1;
       index2 = 2;
      int c = solveLand(land,index1,index2);
      Collections.sort(al);
      if(al.size() > 0){
          String[] data = al.get(0).split("=");
          System.out.println("The Mininum Count is: "+data[0]+" By Traversing through "+data[1]);
      }else{
          System.out.println(0);
      }
      for(String s : al){
        System.out.println(s);
      }
    }
}