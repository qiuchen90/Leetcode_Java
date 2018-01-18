class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left, right = left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { 
                left = (left <= map.get(s.charAt(i))) ? (map.get(s.charAt(i)) + 1) : left;
            } 
            right = i; 
            map.put(s.charAt(i), i);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}