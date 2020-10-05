class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Node> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i), new Node(i / 5, i % 5));
        }
        StringBuilder sb = new StringBuilder();
        Node prev = new Node(0,0);
        for (char c : target.toCharArray()) {
            Node curr = map.get(c);
            int dx = curr.x - prev.x;
            int dy = curr.y - prev.y;
            for (int x = 0; x > dx; x--) {
                sb.append('U');
            }
            for (int y = 0; y > dy; y--) {
                sb.append('L');
            }
            for (int x = 0; x < dx; x++) {
                sb.append('D');
            }
            for (int y = 0; y < dy; y++) {
                sb.append('R');
            }
            
            sb.append('!');
            prev = curr;
        }
        
        return sb.toString();
    }
}