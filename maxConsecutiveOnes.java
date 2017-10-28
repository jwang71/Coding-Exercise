class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        int zero = 0;
        int k = 1;
        
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                zero++;
            }
            
            while (zero > k) {
                if (nums[slow] == 0) {
                    zero--;
                }
                slow++;
            }
            
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}



///follow up  : input is infinite stream. 不能整个放在　memory中，每次更新max时需要的是index，we can use a queue to record index of 0

    public int findMaxConsecutiveOnesInfiniteInput(int[] nums) {
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        int slow = 0;
        int fast = 0;
        int k = 1;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                queue.offer(fast);
            }
            if (queue.size() > k) {
                slow = queue.poll() + 1;
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }