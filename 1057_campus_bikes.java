class Node {
    int dist;
    int worker;
    int bike;
    public Node (int dist, int worker, int bike) {
        this.dist = dist;
        this.worker = worker;
        this.bike = bike;
    }
}

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.dist == n2.dist) {
                    if (n1.worker == n2.worker) {
                        return n1.bike - n2.bike;
                    }
                    return n1.worker - n2.worker;
                }
                return n1.dist - n2.dist;
            } 
        });
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = calcManhattan(workers[i], bikes[j]);
                pq.offer(new Node(dist, i, j));
            }
        }
        
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        Set<Integer> assignedBikes = new HashSet<Integer>();
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (result[curr.worker] == -1 && !assignedBikes.contains(curr.bike)) {
                result[curr.worker] = curr.bike;
                assignedBikes.add(curr.bike);
            }
        }
        
        return result;
    }
    
    private int calcManhattan(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}