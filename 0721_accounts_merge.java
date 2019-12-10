class UnionFind {
    int[] parent;
    
    public UnionFind(int size) {
        parent = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void union(int a, int b) {
        parent[find(a)] = parent[find(b)];
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) {
            return new ArrayList<>();
        }
        
        int n = accounts.size();
        UnionFind unionFind = new UnionFind(n);
        
        //step 1: go through each email and union emails with its associated index
        Map<String, Integer> emailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String currentEmail = accounts.get(i).get(j);
                if (emailToIndex.containsKey(currentEmail)) {
                    unionFind.union(emailToIndex.get(currentEmail), i);
                }
                else {
                    emailToIndex.put(currentEmail, i);
                }
            }
        }
        
        //step 2: traverse through email list and put all emails with the same parent together
        Map<Integer, Set<String>> parentToEmails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parentIndex = unionFind.find(i);
            parentToEmails.putIfAbsent(parentIndex, new HashSet<>());
            
            Set<String> currEmailSet = parentToEmails.get(parentIndex);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                currEmailSet.add(accounts.get(i).get(j));
            }
            
            parentToEmails.put(parentIndex, currEmailSet);
        }
        
        //step 3: sort the emails and add them to the list
        List<List<String>> result = new ArrayList<>();
        for (int parentIndex : parentToEmails.keySet()) {
            List<String> currList = new ArrayList<>();
            currList.addAll(parentToEmails.get(parentIndex));
            Collections.sort(currList);
            currList.add(0, accounts.get(parentIndex).get(0)); // put the names first
            result.add(currList);
        }
        
        return result;
                        
    }
}
