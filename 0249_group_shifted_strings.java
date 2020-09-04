class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = hash(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
    
    private String hash(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            if (diff < 0) {
                diff += 26;
            }
            sb.append(diff).append(",");
        }
        return sb.toString();
    }
}