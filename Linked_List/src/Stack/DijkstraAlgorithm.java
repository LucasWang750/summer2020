package Stack;

public class DijkstraAlgorithm {

    public DijkstraAlgorithm()
    {

    }

    public void calculateShortestPath(Vertex source)
    {
        PriorityQueue queue = new PriorityQueue();

        source.setShortestPath(0);

        queue.enQueue(source);


        while(!queue.isEmpty())
        {

            // Please spend for at least 1 hour to go over this logic. You can draw on the paper before jumping on the computer and typing like we

            // share comments for social media. J

            // we dequeue, now we have vertex A
            Vertex currentVertex = queue.deQueue();

            // then we will look into each edge which is connected to vertex A.
            for(Edge edge : currentVertex.getAdjacencies())
            {
                // if the this edge’s cost/weight + A’s shortestPath < the edge’s target Verter.shortestPath
                int currentShortestPath = edge.getCost() + currentVertex.getShortestPath();
                Vertex targetVertex = edge.getTargetVertex();

                if(currentShortestPath < targetVertex.getShortestPath())
                {
                    // then we will set new shortest path for target vertex (B)and set the new parent vertex for B is A. Finally, we Enqueue vertex B
                    targetVertex.setShortestPath(currentShortestPath);
                    targetVertex.setParentVertex(currentVertex);
                    queue.enQueue(targetVertex);
                }

            }

            // We keep do it the same above logic until the prioiry queue is empty
        }

    }

}
