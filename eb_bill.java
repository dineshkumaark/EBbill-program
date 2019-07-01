import java.util.*;
import java.text.*;
public class Main
{
	public static void main(String[] args) {
	  DecimalFormat df2 = new DecimalFormat("#.##");
	  String s = "Jan 1, 2020: shop1 320$shop2 220$shop3 330$shop4 420$shop5 5";
      String s2 = "Jan 2, 2020: shop5 318$shop4 320$shop3 330$shop2 420$shop1 5";
      String g = "Jan 3, 2020: shop1 316$shop1 820$shop3 330$shop4 420$shop5 5";
      String s3 = s+"^"+s2+"^"+g;
      String[] a = s3.split("\\^");
      HashMap<String,Integer> hm = new HashMap<>();
      for(int i = 0; i < a.length;i++){
          int n = a[i].indexOf(":");
          String j = a[i].substring(n+2);
          String[] c = j.split("\\$");
           for(String b : c){
               String[] x = b.split(" ");
            if(!hm.containsKey(x[0])){
                int u = Integer.parseInt(x[1]);
                hm.put(x[0],u);
           }else{
               int u = Integer.parseInt(x[1]);
               hm.put(x[0],hm.get(x[0])+u);
           }
           }
      }
      TreeMap<String, Integer> sorted = new TreeMap<>(); 
      sorted.putAll(hm);
      sorted.forEach((e,v) -> {
          double cost = 0.0;
          if(v < 1000){
              cost = v * 0.4;
          }else if(v >=1000 && v <=2000){
              cost = v*0.33;
          }else if(v >2000 && v < 5000){
              cost = v*0.3;
          }else if(v>=5000){
              cost = v*0.2;
          }
          System.out.println(e+":"+df2.format(cost));
      });
	}
}
