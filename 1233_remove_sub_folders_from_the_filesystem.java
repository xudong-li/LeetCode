class TrieNode {
    public String s;
    public Map<String, TrieNode> subfolder;
    public boolean isEnd;
    public TrieNode(String s) {
        this.s = s;
        this.subfolder = new HashMap<>();
        this.isEnd = false;
    }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode("root");
        List<String> result = new ArrayList<>();
        
        //build tree
        for (String f : folder) {
            TrieNode curr = root;
            String[] letters = f.split("/");
            for (int i = 0; i < letters.length; i++) {
                //System.out.println(letters[i]);
                if (curr.subfolder.containsKey(letters[i])) {
                    curr = curr.subfolder.get(letters[i]);
                    continue;
                }
                //System.out.println(letters[i]);
                TrieNode temp = new TrieNode(letters[i]);
                curr.subfolder.put(letters[i], temp);
                curr = temp;
            }
            curr.isEnd = true;
        }
        
        //check in tree
        for (String f : folder) {
            TrieNode curr = root;
            String[] letters = f.split("/");
            for (int i = 0; i < letters.length; i++) {
                //System.out.println(letters[i]);
                if (curr.subfolder.get(letters[i]).isEnd) {
                    if (i < letters.length - 1) {
                        break;
                    }
                    result.add(f);
                    break;
                }
                //System.out.println(letters[i]);
                curr = curr.subfolder.get(letters[i]);
            }
        }
        
        return result;
    }
}