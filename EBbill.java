import java.util.*;
import java.text.*;
public class EBbill
{
	public static void main(String[] args) {
	    String str1 = "Jan 1, 2020: shop1 320$shop2 220$shop3 330$shop4 420$shop5 5";
      String str2 = "Jan 2, 2020: shop5 318$shop4 320$shop3 330$shop2 420$shop1 5";
      String str3 = "Jan 3, 2020: shop1 316$shop1 820$shop3 330$shop4 420$shop5 5";
      String str4 = str1+"^"+str2+"^"+str3;

          //Splitting according to Days

      String[] days = str4.split("\\^");

      HashMap<String,Integer> hm = new HashMap<>();

          // Extracting the data from the String

      for(int i = 0; i < days.length;i++){
          int n = days[i].indexOf(":");

          //Finding the index of : to make substring

          String shops = days[i].substring(n+2);

          // Extracting  shops for one day by splitting with $ sign

          String[] shop = shops.split("\\$");

           for(String name : shop){
          // Extracting individual shops by splitting with space

               String[] shp = name.split(" ");
            if(!hm.containsKey(shp[0])){
          // Checking if the shop is new ,if new adding to hashmap

                int num = Integer.parseInt(shp[1]);
                hm.put(shp[0],num);
           }else{
          // If shop already existed updatind the values

               int num = Integer.parseInt(shp[1]);
               hm.put(shp[0],hm.get(shp[0])+num);
           }
           }
      }

      TreeMap<String, Integer> sorted = new TreeMap<>(); 

      // Sorting the hashmap by adding everything to tree map

      sorted.putAll(hm);

      // Taking DecimalFormat to make cost with 2 decimal

      DecimalFormat df2 = new DecimalFormat("#.##");

      // Displaying the Shop Details & Cost

      sorted.forEach((key,value) -> {
          double cost = 0.0;
          if(value < 1000){
              cost = value * 0.4;
          }else if(value >=1000 && value <=2000){
              cost = value * 0.33;
          }else if(value >2000 && value < 5000){
              cost = value * 0.3;
          }else if(value>=5000){
              cost = value * 0.2;
          }
          System.out.println(key+":"+df2.format(cost));
      });
	}
}
