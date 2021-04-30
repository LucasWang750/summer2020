import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.Files.readString;

public class Driver {

    static final int NUM_OF_NODES = 10;
    static final Path SYSTEM_FILE = Paths.get("C:/", "Users", "Lucas", "IdeaProjects", "Quiz", "src", "TreeStructure.dat");
    static final String DELIMITER = ";\n";

    static String systemState;
    static BufferedReader bufferedReader;
    static int requestID;
    static Node requestProcess;
    static List<Node> processList;
    static int rootProcess;

    public static void main(String[] args)
    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            setupTreeStructure();
            printMenu();
            String readLine = bufferedReader.readLine();
            while(!readLine.equals("0"))
            {
                int command = Integer.parseInt(readLine);

                handleCommand(command);
                printMenu();
                readLine = readInputLine();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void printMenu()
    {
        System.out.println("Enter 1.....................Enter Requests");
        System.out.println("Enter 2.....................View the Current System State");
        System.out.println("Enter 0.....................Exit");
    }

    public static void handleCommand(int command)
    {
        switch(command)
        {
            case 1:
                System.out.println("Please Enter a request id (1-10)");
                requestID = Integer.parseInt(readInputLine());
                boolean isRequestValid = validateRequestID(requestID);
                if(isRequestValid)
                {
                    requestProcess = getProcessFromID(requestID);
                    addRequest(requestProcess);
                }
                else
                {
                    System.out.println("Invalid Request ID");
                    break;
                }
                break;
            case 2:
                printSyStemState();
                break;
        }
    }

    public static String readInputLine()
    {
        String input = null;
        try
        {
            input = bufferedReader.readLine().trim();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return input;
        }
        return input;
    }

    public static void printSyStemState()
    {
        for(int i = 0; i < processList.size(); i++)
        {
            System.out.print("P" + processList.get(i).getName() + "(");
            System.out.print("Token:" + processList.get(i).getTokenStatus() + ";");
            System.out.print("Holder:P" + processList.get(i).getHolderVariable() + ";");
            System.out.print("Request Queue: [");
            processList.get(i).getRequestQueue().displayList();
            System.out.print(" ])");
            System.out.println();
        }
    }



    public static void addRequest(Node process)
    {
//        if(process.getTokenStatus() == 1)
//        {
//            process.addToQueue(process);
//        }
//        else
//        {
//            process.addToQueue(process);
//            sendRequestMessageToParent(process);
//        }
        if(process.getRequestQueue().size() == 0)
        {
            sendRequestMessageToParent(process);
        }
        process.addToQueue(process);
    }

    public static void sendRequestMessageToParent(Node requestProcess)
    {
        //put request into parent

        Node holderProcess = getProcessFromID(requestProcess.getHolderVariable());
        holderProcess.addToQueue(requestProcess);

        //check if parent process needs to request into its parent
        requestProcess = getProcessFromID(holderProcess.getName());
        holderProcess = getProcessFromID(requestProcess.getHolderVariable());

        // while the requesting process isn't the root and parent process doesn't have requester: add requester into parent queue
        while(!holderProcess.getRequestQueue().contains(requestProcess) && holderProcess.getName() != requestProcess.getName())
        {

            holderProcess.addToQueue(requestProcess);

            requestProcess = getProcessFromID(holderProcess.getName());
            holderProcess = getProcessFromID(holderProcess.getHolderVariable());
        }
    }

    public static Node getProcessFromID(int ID)
    {
        for(int i = 0; i < NUM_OF_NODES; i++)
        {
            Node currentProcess = processList.get(i);

            if(currentProcess.getName() == ID)
            {
                return currentProcess;
            }
        }
        return null;
    }


    public static boolean validateRequestID(int requestID)
    {
        boolean isValid = false;
        for(Node process : processList)
        {
            if(process.getName() == requestID)
            {
                isValid = true;
            }
        }
        return isValid;
    }

    // setupTreeStructure() initializes the data structure for the system

    // either by the previous saved system state or by the default

    // (the process id 1 is holding the token)

    public static void setupTreeStructure() {

        String str = null;

        try {
            systemState = readString(SYSTEM_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }


        processList = new ArrayList(NUM_OF_NODES);


        int name = 0;

        int tokenStatus = -1;

        int holderVariable = 0;


        Node node = new Node();

        StringTokenizer tokens = new StringTokenizer(systemState, DELIMITER, true);

        while (tokens.hasMoreTokens()) {

            str = tokens.nextToken();

            if (str.compareTo("\n") != 0) {

                if (!(str.equals(";"))) {

                    if (name == 0) {

                        name = Integer.parseInt(str);

                        node.setName(name);
                    } else if (tokenStatus == -1) {

                        tokenStatus = Integer.parseInt(str);

                        if (tokenStatus == 1)
                            rootProcess = name;

                        node.setTokenStatus(tokenStatus);

                    } else if (holderVariable == 0) {

                        holderVariable = Integer.parseInt(str);

                        node.setHolderVariable(holderVariable);

                    }

                }

            } else {
                processList.add(node);

                node = new Node();

                name = 0;

                tokenStatus = -1;

                holderVariable = 0;

            }
        }
    }

}
