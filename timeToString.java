public class HelloWorld{

     public static void main(String []args){
        System.out.println(timeInWords(0, 30));
        System.out.println(timeInWords(1, 0));
        System.out.println(timeInWords(13, 0));
        System.out.println(timeInWords(12, 59));
 
     }
     
public static String timeInWords(int hour, int minute) {
    if (hour > 12 || hour <= 0 || minute >= 60 || minute < 0) return "Invalid Time";
    StringBuilder sb = new StringBuilder();
    
    String h1 = numberToString(hour);
    String h2 = hour == 12 ? numberToString(1) : numberToString(hour + 1);
    String m1 = numberToString(minute);
    String m2 = numberToString(60 - minute);
    
    if (minute == 0) {
        sb.append(h1).append(" ").append("o'clock");
    } else if (minute <= 30) {
        if (minute == 30) {
            sb.append("half").append(" past ").append(h1);
        } else {
            sb.append(m1).append(" past ").append(h1);
        }
    } else {
        sb.append(m2).append(" to ").append(h2);
    }
    return new String(sb);
}
    
    public static String numberToString(int x) {
        if (x == 1) return "one";
        if (x == 2) return "two";
        if (x == 3) return "three";
        if (x == 4) return "fourt";
        if (x == 5) return "five";
        if (x == 6) return "six";
        if (x == 7) return "seven";
        if (x == 8) return "eight";
        if (x == 9) return "nine";
        if (x == 10) return "ten";
        if (x == 11) return "eleven";
        if (x == 12) return "twelve";
        if (x == 15) return "quarter";
        if (x == 20) return "twenty";
      //  if (x == 1) return "one";
        //if (x == 1) return "one";
        return "";
    }
}