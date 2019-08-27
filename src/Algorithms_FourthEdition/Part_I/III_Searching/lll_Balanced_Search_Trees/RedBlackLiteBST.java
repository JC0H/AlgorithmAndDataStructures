package Algorithms_FourthEdition.Part_I.III_Searching.lll_Balanced_Search_Trees;

/*Binary search tree where costs are guaranteed to be logarithmic. Our trees have near-perfect balance, where
the height is guaranteed to be no larger than 2 lg N.

2-3 search trees. The primary step to get the flexibility that we need to guarantee balance in search trees is
to allow the nodes in our trees to hold more than one key. Definition. A 2-3 search tree is a tree that either
is empty or:
A 2-node, with one key (and associated value) and two links, a left link to a 2-3 search tree with smaller keys,
and a right link to a 2-3 search tree with larger keys
A 3-node, with two keys (and associated values) and three links, a left link to a 2-3 search tree with smaller
keys, a middle link to a 2-3 search tree with keys between the node's keys and a right link to a 2-3 search tree
with larger keys.

1.Узел либо красный, либо чёрный.
2.Корень — чёрный. (В других определениях это правило иногда опускается. Это правило слабо влияет на анализ,
так как корень всегда может быть изменен с красного на чёрный, но не обязательно наоборот).
3.Все листья (NIL) — чёрные.
4.Оба потомка каждого красного узла — чёрные.
5.Всякий простой путь от данного узла до любого листового узла, являющегося его потомком, содержит одинаковое
число чёрных узлов.
*/

public class RedBlackLiteBST <Key extends Comparable<Key>, Value> {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST
    private int n;         // number of key-value pairs in BST

    // BST helper node data type
    private class Node {
        private Key key;           // key
        private Value val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    /*Standard BST search.*/
    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if (key == null) throw  new IllegalArgumentException("calls get() with a null key");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else              return node.val;
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/

    public void put(Key key, Value val) {
        root = insert(root, key, val);
        root.color = BLACK;
    }

    private Node insert(Node h, Key key, Value val) {
        if (h == null) {
            n++;
            return new Node(key, val, RED);
        }

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = insert(h.left,  key, val);
        else if (cmp > 0) h.right = insert(h.right, key, val);
        else              h.val   = val;

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

        return h;
    }

    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/

    // is node x red (and non-null) ?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // rotate right
    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // rotate left
    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // precondition: two children are red, node is black
    // postcondition: two children are black, node is red
    private void flipColors(Node h) {
        assert !isRed(h) && isRed(h.left) && isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return n == 0;
    }

}
