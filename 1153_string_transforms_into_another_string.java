/*
        此题的对应有以下几个关系:
        1. 一对一，每一个char互相对应转换即可 a->b
        2. 多对一， aabcc,ccdee, a->c, c->e，其实只要有未在target string出现过的char，那么就可以拿来
        作为temp char桥梁，比如 a->g->c这样转换就不会同时影响c->e的转换
        3. 一对多，a->f, a->g 这样是绝对不可能的，因为char会被同时影响
        
        另外还有一种特殊情况就是，source和target的unique char的数量是一样的时候，如果此时是26个
        则说明完全不能转换，因为没有extra的temp char作为转换的桥梁
*/
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character,Character>();
        
        for (int i = 0; i < str1.length(); i++) {
            Character char1 = str1.charAt(i);
            Character char2 = str2.charAt(i);
            
            if (!map.containsKey(char1)) {
                map.put(char1, char2);
            } else {
                if (!map.get(char1).equals(char2)) {
                    return false;
                }
            }
        }
        
        if (map.keySet().size() == new HashSet(map.values()).size()) {
            return map.size() != 26;
        }
        
        return true;
    }
}