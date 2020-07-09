class RunLengthEncoding {
    String encoding;
    List<Integer> counts;
    
    public RunLengthEncoding(String s) {
        if (s.length() == 0) {
            encoding = "";
            counts = new ArrayList<>();
        } else {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList<>();

            Character prevChar = s.charAt(0);
            int index = 0;
            
            sb.append(prevChar);
            counts.add(1);
            
            for (int i = 1; i < s.length(); i++) {
                Character currChar = s.charAt(i);
                if (currChar.equals(prevChar)) {
                    counts.set(index, counts.get(index) + 1);
                } else {
                    sb.append(currChar);
                    counts.add(1);
                    index++;
                }
                prevChar = currChar;
            }
            
            encoding = sb.toString();
        }
        
    }
}

class Solution {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        RunLengthEncoding rle = new RunLengthEncoding(S);
        search: for (String word : words) {
            RunLengthEncoding currRle  = new RunLengthEncoding(word);
            if (!currRle.encoding.equals(rle.encoding)) {
                continue;
            }
            //System.out.println(currRle.encoding);
            //System.out.println(currRle.counts);
            for (int i = 0; i < currRle.counts.size(); i++) {
                int c1 = rle.counts.get(i);
                int c2 = currRle.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2) {
                    continue search;
                }
            }
            result++;
        }
        return result;
    }
}