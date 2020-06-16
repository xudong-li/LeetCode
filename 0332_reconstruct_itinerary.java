class Solution {
    Map<String, LinkedList<String>> flightMap = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. construct the flight graph;
        for (List<String> ticket : tickets) {
            if (!this.flightMap.containsKey(ticket.get(0))) {
                this.flightMap.put(ticket.get(0), new LinkedList<String>());
            }
            this.flightMap.get(ticket.get(0)).add(ticket.get(1));
        }
        
        // 2. sort the destinations in order
        this.flightMap.forEach((key, value) -> Collections.sort(value));
        
        //3. traverse the flight map using DFS
        DFS("JFK");
        return result;
    }
    
    private void DFS(String origin) {
        // visit all outgoing edge first
        if (this.flightMap.containsKey(origin)) {
            LinkedList<String> destinationList = this.flightMap.get(origin);
            while (!destinationList.isEmpty()) {
                String destination = destinationList.pollFirst();
                DFS(destination);
            }
        }
        
        this.result.offerFirst(origin);
    }
}