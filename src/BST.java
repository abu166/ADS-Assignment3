public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node( K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val; // update the value if key already exists
        }
        return node;
    }

    public V get(K key){
        return get( root, key);
    }

    private V get(Node node, K key){
        while(node != null){
            int cmp = key.compareTo(node.key);
            if( cmp < 0) node = node.left;
            else if(cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }
//    public void delete(K key){
//
//    }


    private Node min( Node x ){
        while( x.left != null ) x = x.left;
        return x;
    }
    private Node deleteMin( Node x ){
        if( x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;

    }
    public int size(){
        return size;
    }

    public Iterable<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node != null) {
            inOrder(node.left, keys);
            keys.add(node.key);
            inOrder(node.right, keys);
        }
    }

    public Iterable<Node> nodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        inOrderNodes(root, nodes);
        return nodes;
    }

    private void inOrderNodes(Node node, ArrayList<Node> nodes) {
        if (node != null) {
            inOrderNodes(node.left, nodes);
            nodes.add(node);
            inOrderNodes(node.right, nodes);
        }
    }


}
