public class Queue extends LinkedList
{
    public void enQueue(int newData)
    {
        super.insertAtEnd(newData);
    }

    public Node deQueue()
    {
        return super.removeAtFront();
    }

    public boolean contains(Node current)
    {
        Node temp = head;

        while(temp != null)
        {
            if(current.data == temp.data)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
