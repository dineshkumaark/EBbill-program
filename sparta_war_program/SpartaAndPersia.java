import java.util.*;

public class SpartaAndPersia{
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int persian = 0,spart=0;
   int count = 0;
  // int n = sc.nextInt();
  // String[] arr = new String[n];
  // for(int i = 0; i < n;i++){
  //   arr[i] = sc.next();
  // }
  int n = 2;
  String[] arr = {"H..eX.$","EX.$"};
  HashMap<Character,Integer> hm = new HashMap<>();
  hm.put('A',3);
  hm.put('a',3);
  hm.put('C',1);
  hm.put('c',1);
  hm.put('E',10);
  hm.put('e',10);
  hm.put('H',5);
  hm.put('h',5);
  hm.put('X',2);
  hm.put('.',1);
  for(int i = 0; i < n;i++){
    char[] el = arr[i].toCharArray(); 
     if(hm.containsKey(el[i])){
       for(int j = el.length - 1;j >= 0;j--){
           if(el[j] == '.'){
               count++;
               continue;
           }
           if(el[j] == 'X'){
               count = count + 2;
               continue;
           }
           if(el[j] == 'h' || el[j] == 'e' || el[j] == 'c' || el[j] == 'a'){
               persian += hm.get(el[j]) * count; 
               count = 0;
           }
           if(el[j] == 'H' || el[j] == 'E' || el[j] == 'C' || el[j] == 'A'){
               spart += hm.get(el[j]) * count; 
               count = 0;
           }
      }
    }
   }
   if(persian > spart){
        System.out.println("Persia Wins");
    }else{
        System.out.println("Sparta Wins");
    }
}
}