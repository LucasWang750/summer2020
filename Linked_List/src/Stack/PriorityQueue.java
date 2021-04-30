package Stack;

public class PriorityQueue extends LinkedList
{
    public boolean isEmpty()
    {
        return head.next == null;
    }

    public void enQueue(Vertex newData) //short on left end
    {
        Node newNode = new Node(newData); // new container for data
        Node temp = null; //first node

        if(isEmpty())
        {
            super.insertEnd(newNode.data);
        }
        else {
            temp = head;

            //if there's a next node and next node data is bigger than newNode data
            while ( temp.next != null && !(temp.next.data.getShortestPath() > newNode.data.getShortestPath()))
            {
                temp = temp.next;
            }

            if(temp.next != null) //if temp is not the last node, then make it newNode point to the next node.
            {
                newNode.next = temp.next;
            }

            temp.next = newNode;
        }

    }

    public Vertex deQueue()
    {
        return super.removeFront();
    }

    public void print()
    {
        super.print("Priority Queue");
    }

}
