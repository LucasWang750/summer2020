package Stack;

class Stack extends LinkedList
{
    public void push(Vertex newData)
    {
        super.insertEnd(newData);
    }

    public Vertex pop()
    {
        return super.removeEnd();
    }

    public void print()
    {
        super.print("Stack");
    }
}

