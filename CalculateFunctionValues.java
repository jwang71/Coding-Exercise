import java.util.*;
public class HelloWorld{
     public static void main(String []args){
        List<Integer> list = new ArrayList(Arrays.asList(-5,-4, -3, 2, 3));
        List<Integer> result = functionValues(1,0,0,list);
        for (int i : result) {
            System.out.println(i);
        }
     }
     
     public static List<Integer> functionValues(int a, int b, int c, List<Integer> list) {
         List<Integer> res = new ArrayList<>();
         int mid = (-1) * b/(2*a);
         int size = list.size();
        //System.out.println(size);
         if (list.get(size - 1) <= mid) {
             if (a > 0) {
                 for (int i = size - 1; i >= 0; i--) {
                     int value = a*list.get(i)*list.get(i) + b*list.get(i) + c;
                     res.add(value);
                 }
             } else {
                 for (int i = 0; i < size; i++) {
                     int value = a*list.get(i)*list.get(i) + b*list.get(i) + c;
                     res.add(value);
                 }
             }
         } else if (list.get(0) >= mid) {
             if (a > 0) {
                 for (int i = 0; i < size; i++) {
                     int value = a*list.get(i)*list.get(i) + b*list.get(i) + c;
                     res.add(value);
                 }                 
             } else {
                 for (int i = size - 1; i >= 0; i--) {
                     int value = a*list.get(i)*list.get(i) + b*list.get(i) + c;
                     res.add(value);
                 }                 
             }
         } else {
             int[] array = listToArray(list);
            int index = findClosestToMid(array, mid);
            int left = index;
            int right = index;
            
             while (left >= 0 && right < array.length) {          
                int value1 = a*array[left]*array[left] + b*array[left] + c;
                int value2 = a*array[right]*array[right] + b*array[right] + c;
                if (value1 <= value2) {
                    res.add(value1);
                    left--;
                } else {
                    res.add(value2);
                    right++;
                }
             }
             while (left >= 0) {
                int value1 = a*array[left]*array[left] + b*array[left] + c;
                res.add(value1);
                left--;
             }
             while (right < array.length) {
                int value2 = a*array[right]*array[right] + b*array[right] + c;
                res.add(value2);      
                right++;
             }
         }
         return res;
     }
     
     private static int findClosestToMid(int[] array, int target) {
         int start = 0;
         int end = array.length - 1;
         while (start + 1 < end) {
             int mid = start + (end - start)/2;
             if (array[mid] == target) {
                 return mid;
             } else if (array[mid] < target){
                 start = mid;
             } else {
                 end = mid;
             }
         }
         if (target - array[start] <= array[end] - target) {
             return start;
         } else {
             return end;
         }
     }
     
     private static int[] listToArray(List<Integer> list) {
         int[] array = new int[list.size()];
         for (int i = 0; i < list.size(); i++) {
             array[i] = list.get(i);
         }
         return array;
     }
}