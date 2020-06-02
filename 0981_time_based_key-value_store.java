class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair<Integer, String>>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer,String>> list = map.get(key);
        int index = binarySearch(list, timestamp);
        if (index == -1) {
            return "";
        }
        return list.get(index).getValue();
    }
    
    private int binarySearch(List<Pair<Integer,String>> list, int timestamp) {
        int start = 0, end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid).getKey() <= timestamp) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (list.get(end).getKey() <= timestamp) {
            return end;
        }
        if (list.get(start).getKey() <= timestamp) {
            return start;
        }
        return -1;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */