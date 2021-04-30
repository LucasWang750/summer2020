package Stack;

public class DijkstraDriver {
    public static void main(String[] args)
    {

        Vertex n1 = new Vertex("A");

        Vertex n2 = new Vertex("B");

        Vertex n3 = new Vertex("C");

        Vertex n4 = new Vertex("D");

        Vertex n5 = new Vertex("E");

        Vertex n6 = new Vertex("F");

        Vertex n7 = new Vertex("G");

        Vertex n8 = new Vertex("H");

        Vertex n9 = new Vertex("I");

        Vertex n10 = new Vertex("J");


//          initialize the edges

        n1.setAdjacencies(new Edge[]{

                new Edge(n2, 75),

                new Edge(n4, 140),

                new Edge(n8, 118)

        });


        n2.setAdjacencies(new Edge[]{

                new Edge(n1, 75),

                new Edge(n3, 71)

        });


        n3.setAdjacencies(new Edge[]{

                new Edge(n2, 71),

                new Edge(n4, 151)

        });


        n4.setAdjacencies(new Edge[]{

                new Edge(n1, 140),

                new Edge(n5, 99),

                new Edge(n3, 151),

                new Edge(n6, 80),

        });


        n5.setAdjacencies(new Edge[]{

                new Edge(n4, 99),

        });


        n6.setAdjacencies(new Edge[]{

                new Edge(n4, 80),

                new Edge(n7, 97),

        });


        n7.setAdjacencies(new Edge[]{

                new Edge(n6, 97),

        });


        n8.setAdjacencies(new Edge[]{

                new Edge(n1, 118),

                new Edge(n9, 111)

        });


        n9.setAdjacencies(new Edge[]{

                new Edge(n8, 111),

                new Edge(n10, 70)

        });


        n10.setAdjacencies(new Edge[]{

                new Edge(n9, 70),

        });


        Vertex source = n1;

        Vertex destination = n7;


        DijkstraAlgorithm DijkstraAlg = new DijkstraAlgorithm();

        DijkstraAlg.calculateShortestPath(source);

        printResult(destination);

        //DijkstraAlg.printAllPath();

        //You can implement anything you like to print out the result.


    }

//    private static void printResult(Vertex destination)
//    {
//        Stack stack = new Stack();
//
//        //get all Vertex associated with destination's shortest path to source
//        while(destination != null)
//        {
//            stack.push(destination);
//            destination = destination.getParentVertex();
//        }
//
//        while(!stack.isEmpty())
//        {
//            Vertex currentVertex = stack.pop();
//            System.out.println(currentVertex);
//        }
//    }

    private static void printResult(Vertex destination)
    {
        Stack stack = new Stack();

        //get all Vertex associated with destination's shortest path to source
        while(destination != null)
        {
            stack.insertFront(destination);
            destination = destination.getParentVertex();
        }

        stack.print();
    }
}
