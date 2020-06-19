/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> result;
    int curr = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        flattenList(nestedList);
    }
    
    private void flattenList(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            if (!nestedList.get(i).isInteger()) {
                List<NestedInteger> list = nestedList.get(i).getList();
                flattenList(list);
            } else {
                result.add(nestedList.get(i).getInteger());
            }
        }
    }

    @Override
    public Integer next() {
        int value = result.get(curr);
        curr++;
        return value;
    }

    @Override
    public boolean hasNext() {
        if (curr >= result.size()) {
            return false;
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */