package Stack;

public class Edge {

    private Vertex targetVertex;
    private int cost;

    public Edge()
    {
        this.targetVertex = null;
        this.cost = -1;
    }

    public Edge(Vertex targetVertex, int cost)
    {
        this.targetVertex = targetVertex;
        this.cost = cost;
    }


    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
