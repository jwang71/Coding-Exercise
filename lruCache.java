public class Solution<K, V> {
  // limit is the max capacity of the cache
  Map<K, Node<K, V>> map;
  private final int limit;
  private Node head;
  private Node tail;
  
  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<K, Node<K, V>>();
  }
  
  public void set(K key, V value) {
    Node<K, V> node = null;
    if (map.containsKey(key)) {
      //move the node to the head
      node = map.get(key);
      node.value = value;
      remove(node);
      append(node);
    } else {
      if (map.size() < limit) {
        node = new Node(key, value);
        append(node);
      } else {
        node = tail;
        remove(node);
        node.update(key, value);
        append(node);
      }
    }
  }
  
  public V get(K key) {
    Node<K,V> node = map.get(key);
    if (node == null) return null;
    remove(node);
    append(node);
    return node.value;
  }
  
  public void remove(Node<K, V> node) {
    map.remove(node.key);
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == head) {
      head = head.next;
    }
    if (node == tail) {
      tail = tail.prev;
    }
    node.next = node.prev = null;
  }
  
  public void append(Node<K,V> node) {
    map.put(node.key, node);
    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
  
  static class Node<K, V>{
    Node<K, V> next;
    Node<K, V> prev;
    K key;
    V value;
    
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
    public void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}
