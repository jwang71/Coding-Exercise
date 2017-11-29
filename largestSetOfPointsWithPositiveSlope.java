/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
  public int largest(Point[] points) {
    Arrays.sort(points, new MyComparator());
    int[] dp = new int[points.length];
    int res = 0;
    
    for (int i = 0; i < points.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < points.length; j++) {
        if (points[j].x < points[i].x && points[j].y < points[i].y) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res == 1 ? 0 : res;
  }
  
  public class MyComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
      if (p1.x == p2.x && p1.y == p2.y) return 0;
      if (p1.x < p2.x) {
        return -1;
      } else if (p1.x > p2.x) {
        return 1;
      } else if (p1.y < p2.y) {
        return -1;
      } else {
        return 1;
      }
    }
  }
