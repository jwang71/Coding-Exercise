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
  public int most(Point[] points) {
    int res = 0;
    for (int i = 0; i < points.length; i++) {
      HashMap<Double, Integer> map = new HashMap<>();
      int same = 1;
      int sameX = 0;
      int most = 0;
      for (int j = 0; j < points.length; j++) {
        if (i == j) continue;
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          same++;
        } else if (points[i].x == points[j].x) {
          sameX++;
        } else {
          double slope = ((points[i].y - points[j].y) + 0.0)/ ((points[i].x - points[j].x)+0.0);
          if (!map.containsKey(slope)) {
            map.put(slope, 1);
          } else {
            map.put(slope, map.get(slope) + 1);
          }
          most = Math.max(most, map.get(slope));
        }
      }
      res = Math.max(res, Math.max(most, sameX) + same);
    }
    
    return res;
  }
