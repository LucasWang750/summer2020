package Stack;

class Node {

    Vertex data;
    Node next;

    public Node(Vertex d)
    {
        data = d;
        next = null;
    }
    public Node()
    {
        data = null;
        next = null;
    }

}
