class BrowserHistory {
    
    private List<String> list = new ArrayList<>();
    private int currPage = 0;
    
    public BrowserHistory(String homepage) {
        list.add(homepage);
    }
    
    public void visit(String url) {
        list.subList(currPage + 1, list.size()).clear();
        list.add(url);
        currPage = list.size() - 1;
    }
    
    public String back(int steps) {
        currPage = Math.max(0, currPage - steps);
        return list.get(currPage);
    }
    
    public String forward(int steps) {
        currPage = Math.min(list.size() - 1, currPage + steps);
        return list.get(currPage);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */