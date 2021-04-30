public class Node {
    public int data; // data item name
    public Node next; // pointer to next node in list
    private int tokenStatus;
    private int holderVariable;
    private Queue requestQueue;


    public Node(int data)
    {
        this.data = data;
        next = null;
        tokenStatus = -1;
        holderVariable = 0;
        requestQueue = new Queue();
    }

    public Node() {
        this.data = -1;
        requestQueue = new Queue();
        tokenStatus = -1;
        holderVariable = -1;
        next = null;
    }

    public void setName(int name)
    {
        this.data = name;
    }

    public int getName()
    {
        return this.data;
    }

    public int getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(int tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public int getHolderVariable() {
        return holderVariable;
    }

    public void setHolderVariable(int holderVariable) {
        this.holderVariable = holderVariable;
    }

    public Queue getRequestQueue()
    {
        return requestQueue;
    }

    public void addToQueue(Node process)
    {
        requestQueue.enQueue(process.data);
    }

    public Node deQueue()
    {
        return requestQueue.deQueue();
    }

    public void displayNode()
    {
        System.out.print("P" + data + " ");
    }

}
