import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        List<Integer> input = Arrays.asList(1,1,3,3,2,4,5,3,7,9,100);
        System.out.println(findTopK(input, 5));
     }
    public static List<Integer> findTopK(List<Integer> input, int k) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    	for (int i : input) {
    		if (minHeap.size() < k) {
    			minHeap.offer(i);
    		} else {
    			if (i > minHeap.peek()) {
    				minHeap.poll();
    				minHeap.offer(i);
    			}
    		}
    	}
    
    	List<Integer> res = new ArrayList<>();
    	while (!minHeap.isEmpty()) {
    		res.add(minHeap.poll());
    	}
    	return res;
    }
}