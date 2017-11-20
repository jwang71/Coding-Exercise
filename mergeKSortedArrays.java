  public int[] merge(int[][] arrayOfArrays) {
    int n = arrayOfArrays.length;
    PriorityQueue<Item> minHeap = new PriorityQueue<Item>(n, new Comparator<Item>(){
      public int compare(Item i1, Item i2) {
        if (i1.value == i2.value) return 0;
        return i1.value < i2.value ? -1 : 1;
      }
    });
    
    int length = 0;
    for (int i = 0; i < n; i++) {
      if (arrayOfArrays[i] != null && arrayOfArrays[i].length != 0) {
        minHeap.offer(new Item(i, 0, arrayOfArrays[i][0]));
      }
      length += arrayOfArrays[i].length;
    }
    
    int[] result = new int[length];
    int count = 0;
    while (!minHeap.isEmpty()) {
      Item item = minHeap.poll();
      result[count++] = item.value;
      if (item.y + 1 < arrayOfArrays[item.x].length) {
        minHeap.offer(new Item(item.x, item.y + 1, arrayOfArrays[item.x][item.y+1]));
      }
    }
    return result;
  }
  
  public class Item {
    int x;
    int y;
    int value;
    public Item (int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
