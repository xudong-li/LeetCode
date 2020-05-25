class Node {
    int x;
    int y;
    int dist;
    public Node (int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = x * x + y * y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((n1,n2) -> (n2.dist - n1.dist));
        maxHeap.add(new Node(points[0][0], points[0][1]));
        
        for (int i = 1; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (maxHeap.size() < K) {
                maxHeap.add(new Node(points[i][0], points[i][1]));
            }
            else if (dist < maxHeap.peek().dist) {
                maxHeap.poll();
                maxHeap.add(new Node(points[i][0], points[i][1]));
            }
        }
        
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Node curr = maxHeap.poll();
            result[i][0] = curr.x;
            result[i][1] = curr.y;
        }
        
        return result;
    }
}