package Stack;

// whole class is made for testing purposes

public class Vertex {

    private Edge[] adjacencies;
    private String name;
    private int shortestPath;
    private Vertex parentVertex;

    public Vertex()
    {
        this.adjacencies = null;
        this.name = null;
        this.shortestPath = Integer.MAX_VALUE;
        this.parentVertex = null;
    }

    public Vertex(String newName)
    {
        this.adjacencies = null;
        this.name = newName;
        this.shortestPath = Integer.MAX_VALUE;
        this.parentVertex = null;
    }

    public void setShortestPath(int newShortestPath)
    {
        this.shortestPath = newShortestPath;
    }

    public int getShortestPath()
    {
        return this.shortestPath;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public String getName()
    {
        return this.name;
    }

    public void setParentVertex(Vertex newParentVertex)
    {
        this.parentVertex = newParentVertex;
    }

    public Vertex getParentVertex()
    {
        return this.parentVertex;
    }

    public void setAdjacencies(Edge[] newAdjacencies) {
        this.adjacencies = newAdjacencies;
    }

    public Edge[] getAdjacencies() {
        return this.adjacencies;
    }

    @Override
    public String toString()
    {
        return "Vertex " + name  + " Cost: " + shortestPath ;
    }

}
