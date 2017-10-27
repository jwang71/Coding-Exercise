class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        long prev = (long)lower - 1;
        long cur = 0;
        for (int i = 0; i <= nums.length; i++) {
            cur = i == nums.length ? (long)upper + 1 : nums[i];
            if (cur - prev > 1) {
                list.add(helper(list, prev + 1, cur - 1));
            }
            prev = cur;
        }
        return list;
    }
    public String helper(List<String> list, long start, long end) {
        if (start == end) return String.valueOf(start);
        return start + "->" + end;
    } 
}