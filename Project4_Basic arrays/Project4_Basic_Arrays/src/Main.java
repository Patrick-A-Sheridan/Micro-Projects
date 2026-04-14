import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String SetIn = "";
        ArrayList<Integer> Output = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //takes input to get list
System.out.println("\n Please enter your list, this should be in the format ##, ##, ...:");
 SetIn = sc.nextLine();
        // outputs original list
        System.out.println("\n"+"to organize: "+SetIn+"\n");
        //String list to integer list
        Output = stringToList(SetIn);
        System.out.println(Output +"\n");
    // outputs sorted list
        Output = SortList(Output);
        System.out.println(Output +"\n");

        //outputs mean, median, mode, range
        System.out.println("Mean: "+ GetMean(Output));
        System.out.println("Median: "+ GetMedian(Output));
        System.out.println("Mode: "+ GetMode(Output));
       System.out.println("Range: "+GetRange(Output));
    }
    // Converts StringList to int
  public static ArrayList<Integer> stringToList(String Input) {
      ArrayList<Integer> IntList = new ArrayList<>(); 

       String num = Input; 
       String str[] = num.split(", ");
    List<String> al = new ArrayList<String>();
    al = Arrays.asList(str);
    for (String s : al) {
        IntList.add(Integer.parseInt(s));
    }
      

        return IntList;
    }
    // sorts int list
    public static ArrayList<Integer> SortList(ArrayList<Integer> ToSort) {
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted = ToSort;
        Collections.sort(sorted);
        return sorted;
    }

    // finds mean of list
    public static double GetMean(ArrayList<Integer> inList) {
        double mean_out = 0.0;
        for (int i = 1; i <= inList.size(); i++)
            mean_out += inList.get(i-1);
        mean_out /= inList.size();
    return mean_out;
    }

    // finds median of list
    public static double GetMedian(ArrayList<Integer> inList) {
        Collections.sort(inList);
        double middle_num = inList.get(inList.size() / 2);
        double median = 0;
        if (inList.size() % 2 != 0) {
            median = middle_num;
        } else {

            median = (middle_num + inList.get(inList.size() / 2 - 1)) / 2;
        }

        return median;
    }

    // finds mode of list
public static int GetMode(ArrayList<Integer> inList) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int mode = inList.get(0);
        int maxCount = 0;

        for (int v : inList) {
            int count = freq.getOrDefault(v, 0) + 1;
            freq.put(v, count);
            if (count > maxCount) {
                maxCount = count;
                mode = v;
            }
        }
        return mode;
    }
//finds range of list
     public static int GetRange(ArrayList<Integer> inList) {
    Collections.sort(inList);
        int range = inList.get(inList.size()-1)-inList.get(0);

        return range;
    }
}