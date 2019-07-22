class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String currSortedString = new String(curr);
            
            if (map.containsKey(currSortedString)) {
                map.get(currSortedString).add(strs[i]);
                //System.out.println(strs[i]);
            } else {
                map.put(currSortedString, new ArrayList<String>());
                map.get(currSortedString).add(strs[i]);
            }
        }
        
        
        for (List<String> val : map.values()) {
            result.add(val);
        }
        
        return result;
    }
}