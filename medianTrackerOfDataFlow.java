//MedianTracker will call read() method to read the values one by one
public class MedianTracker {
  PriorityQueue<Integer> smallPart;
  PriorityQueue<Integer> largePart;
  
  public MedianTracker() {
    largePart = new PriorityQueue<Integer>();
    smallPart = new PriorityQueue<Integer>(11, Collections.reverseOrder());
  }
  
  public void read(int value) {
    // We maintain the property: 
    // size(smallPart) == size(largePart) when even number of values read
    // size(smallPart) == size(largePart) + 1 when odd number 
    if (smallPart.isEmpty() || value <= smallPart.peek()) {
      smallPart.offer(value);
    } else {
      largePart.offer(value);
    }
    

    //After insert the value, only when size(small) == size(large) + 2  or size(//small) == size(large) - 1 will break the balance, and we need to do the //adjustment accordingly
    if (smallPart.size() - largePart.size() >= 2) {
      largePart.offer(smallPart.poll());
    } else if (largePart.size() > smallPart.size()) {
      smallPart.offer(largePart.poll());
    }
    
  }
  
  public Double median() {
    // write your implementation here.
    int size = this.size();
    if (size == 0) {
      return null;
    } else if (size % 2 == 0) {
      return (smallPart.peek() + largePart.peek())/2.0;
    } else {
      return (double)(smallPart.peek());
    }
  }
  
  private int size() {
    return smallPart.size() + largePart.size();
  }
}
