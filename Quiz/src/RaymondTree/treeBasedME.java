package RaymondTree;
import java.util.*	;
import java.io.*	;

public class treeBasedME
{
    private static final int NUM_OF_NODES = 11;
    private static final boolean SUCCESS = true;
    private static final int NOT_HOLDING = 0;
    private static final int HOLDING = 	1;
    private static final String DELIMITER = ";";
    private static final String SYSTEM_FILE = "TreeStructure.dat";
    private static ArrayList _system;
    private static int _root;

    // Node class consists its associated information such as
// its site name, whether it holds the token or not, who is
// its holder variable (to whom it passes the request message),
// and the request queue.  Node class might be considered as
// a site in the system.
    private class Node {
        private static final int NULL = -1;
        // private data members:
        private int _pId;
        private int _tokenStatus;
        private int _holderVariable;
        private ArrayList _requestQueue;

        // The default constructor: it just initializes the request queue.
        // to a blank new queue.
        public Node() {
            _requestQueue = new ArrayList() ;
        }

        // setName() assigns to a given process id.
        public void setName( int pid ) {
            _pId = pid;
        }

        // setTokenStatus() assigns a token status into either two states:
        // holding the token or not holding the token. In this program,
        // holding token is represented as 1 and not holding token is
        // represented as 0.
        public void setTokenStatus( int token ) {
            _tokenStatus = token	;
        }

        // setHolderVariable() assigns to a given current holder variable,
        // so the node can know where to pass the request message.
        public void setHolderVariable( int holderVariable ) {
            _holderVariable = holderVariable	;
        }

        // addRequest() inserts the new request to the request queue.
        // The request queue is FIFO, so the request is always inserted
        // at the end of the queue.
        public void addRequest( int pid ) {
            _requestQueue.add( pid ) ;
        }

        // removeRequest() deletes the request at the front of the queue
        // because the queue is FIFO.
        public int removeRequest() {
            if ( !_requestQueue.isEmpty() )	{
                Integer element = ( Integer ) _requestQueue.get ( 0 )	;
                _requestQueue.remove( 0 )	;
                return element;
            }
            else
                return NULL	;
        }

        // getName() returns its name (process id).
        public int getName() {
            return _pId	;
        }

        // getTokenStatus() returns either 1 or 0. 1 is represented for
        // holding the token, 0 is represented for not holding the token.
        public int getTokenStatus() {
            return _tokenStatus	;
        }

        // getHolderVariable() returns its holder variable.
        public int getHolderVariable() {
            return _holderVariable	;
        }

        // isRequestQueueEmpty() returns true if the request queue is empty.
        // Otherwise, it returns false.
        public boolean isRequestQueueEmpty() {
            return _requestQueue.isEmpty()	;
        }

        // getNumOfRequests() returns the number of current requests
        // in the request queue.
        public int getNumOfRequests() {
            return _requestQueue.size()	;
        }

        // printRequestQueue() displays all the requests in the request queue
        // on the screen in a certain format.
        public String printRequestQueue() {
            String requestQueue	= new String()	;
            for ( int i = 0; i < _requestQueue.size(); i++ ) {
                requestQueue += "P"	;
                requestQueue += _requestQueue.get( i )	;
                requestQueue += ","	;
            }
            requestQueue += "0"	;
            return requestQueue ;
        }

        // getRequestQueue() returns all the requests in the request queue
        // in the certain format as a string.
        public String getRequestQueue() {
            String requestQueue	= new String()	;
            for ( int i = 0; i < _requestQueue.size(); i++ ) {
                requestQueue += _requestQueue.get( i )	;
                requestQueue += DELIMITER	;
            }
            requestQueue += "\n"	;
            return requestQueue ;
        }

        public ArrayList getQueue()
        {
            return _requestQueue;
        }
    }  // end of Node class

    // setupTreeStructure() initializes the data structure for the system
// either by the previous saved system state or by the default
// (the process id 1 is holding the token)
    public boolean setupTreeStructure() {
        _system = new ArrayList( NUM_OF_NODES )	;
        _system.add( new Node() )	;

        // to read the previous saved system state from the system file
        String systemState = readString( SYSTEM_FILE )	;
        String str = null	;
        int name = 0	;
        int tokenStatus = -1	;
        int holderVariable = 0	;

        Node node = new Node()	;

        // The previous system state was saved (the system file is found)
        if ( systemState != null ) {
            // The following code is used to initialize each node (site) in the system with
            // its previous saved state.
            StringTokenizer tokens = new StringTokenizer( systemState, ";\n", true )	;
            while ( tokens.hasMoreTokens() ) {
                str = tokens.nextToken() 	;

                if ( str.compareTo("\n") != 0 ) {
                    if ( !( str.equals( DELIMITER ) ) ) {
                        if ( name == 0 ) {
                            name = Integer.parseInt( str )	;
                            node.setName( name )	;
                        }
                        else if ( tokenStatus == -1 ) {
                            tokenStatus = Integer.parseInt( str )	;
                            if ( tokenStatus == HOLDING )
                                _root = name	;
                            node.setTokenStatus( tokenStatus )	;
                        }
                        else if ( holderVariable == 0 ) {
                            holderVariable = Integer.parseInt( str )	;
                            node.setHolderVariable( holderVariable )	;
                        }
                    }
                }
                else {
                    _system.add( node )	;
                    node = new Node() ;
                    name = 0	;
                    tokenStatus = -1	;
                    holderVariable = 0	;
                }
            }
            currentTreeStructure();
            return SUCCESS	;
        }

        // If the previous system state was not saved (the system file is not found)
        _root = 1	;

        // The following code is used to initialize each node (site) in the system with
        // the default state (Node 1 is holding the token).
        for ( int i = 1 ; i < NUM_OF_NODES ; i++ ) {
            node = new Node()	;
            node.setName ( i ) 	;

            if ( i == _root ) {
                node.setTokenStatus( HOLDING )	;
                node.setHolderVariable( _root )	;
            }
            else {
                node.setTokenStatus( NOT_HOLDING )	;
                node.setHolderVariable ( ( int ) Math.floor( i / 2 ) )	;
            }
            _system.add( node ) 	;
        }

        saveSystemState();
        currentTreeStructure();
        return !SUCCESS	;
    }
    // currentTreeStructure() returns the system state as a string, which is already put
// into one display format.
    public String currentTreeStructure() {
        String systemState = new String()	;

        for ( int i = 1; i < NUM_OF_NODES; i++ ) {
            Node node = ( Node ) _system.get ( i )	;
            systemState = systemState + "P" + node.getName() + "("	;
            systemState = systemState + "Token:" + node.getTokenStatus() + ";";
            systemState = systemState + "Holder:P" + node.getHolderVariable() + ";";
            systemState = systemState + "Request_Q:[" + node.printRequestQueue();
            systemState = systemState + "])\n"	;
        }
        return systemState	;
    }

    // updateTreeStructure() updates the data structure of the system. The requests are passed // in as a string.
    public void updateTreeStructure( String requestors ) {
        if ( requestors == null ) {
            System.out.println( "Please enter the requests..." )	;
            return	;
        }

        StringTokenizer tokens = new StringTokenizer( requestors, DELIMITER );
        String request = null	;

        // The following lines are used to making one request entering the critical session.
        // The request is added into its own node (site), then the node (site) will forward
        // the request to its holder variable if it has not sent any request yet and it is not
        // holding the token.
        while( tokens.hasMoreTokens() ) {
            request = tokens.nextToken()	;
            int requestId = Integer.parseInt( request )	;
            Node node = ( Node ) _system.get( requestId )	;

            node.addRequest( requestId )	;
            _system.set( requestId, node )	;

            if ( node.getNumOfRequests() == 1 && node.getTokenStatus() == NOT_HOLDING )
                makingRequest( node.getHolderVariable(), requestId )	;
        }
    }

    // makingRequest() to add the given request into the given node (site).  It also
    // forwards the request to its holder variable if it has not sent any request to its
    // holder variable and it is not holding the token.
    private void makingRequest( int pid, int requestId ) {
        Node node = ( Node ) _system.get( pid )	;
        node.addRequest( requestId )	;
        _system.set( pid, node ) 	;

        if ( node.getNumOfRequests() == 1 && node.getTokenStatus() == NOT_HOLDING )
            makingRequest( node.getHolderVariable(), pid )	;
    }

    // executeRequests() calls runRaymondAlg(), which is Raymond's tree algorithm.
// This method is needed because we want to return a string to its caller.
// However, it is not neccessary if it can be allowed to display any process
// enters the critical session on the screen directly.
    public String executeRequests() {
        String result = new String()	;
        result = runRaymondAlg( result )	;
        saveSystemState() 	;
        return result	;
    }

    // runRaymondAlg() to execute Raymond's tree algorithm
    private String runRaymondAlg( String enterCriticalSessionResult ) {
        String result = new String( enterCriticalSessionResult )	;

        // rootNode is the node (site), which is currently holding the token
        Node rootNode = ( Node ) _system.get( _root ) 	;


        // if the rootNode does not have any request in its request queue
        if ( rootNode.isRequestQueueEmpty () )
            return result	;
        // to get the request with highest priority (at the top of the request queue)
        int topRequestor = rootNode.removeRequest ()	;

        // after enter the critical session, the token will be passed to the request
        // at the top of the request queue if the request queue is not empty
        if ( topRequestor == _root ) {
            result += ( "P" + topRequestor + " entered critical session\n" )	;
            System.out.println(currentTreeStructure());
            if( !rootNode.isRequestQueueEmpty())
            {
                topRequestor = rootNode.removeRequest();
                if(topRequestor == _root)
                {
                    result += ( "P" + topRequestor + " entered critical session\n" )	;
                    if( !rootNode.isRequestQueueEmpty()) {
                        topRequestor = rootNode.removeRequest();
                    }
                }
            }
        }



        // the following lines are used to make the transition of the token from the current
        // node (site) to the next request
        rootNode.setHolderVariable( topRequestor )	;
        rootNode.setTokenStatus( NOT_HOLDING )	;
        _system.set( _root, rootNode )	;

        int newRoot = topRequestor	;
        Node newRootNode = ( Node ) _system.get( newRoot )	;
        newRootNode.setTokenStatus( HOLDING )	;
        newRootNode.setHolderVariable( newRoot )	;
        _system.set( newRoot, newRootNode )	;

        // if the request queue still has any request, then the node will make a request
        // with the node (site), which is holding the token next.
        if ( !rootNode.isRequestQueueEmpty()) {
            makingRequest( topRequestor, _root )	;
        }


        _root = newRoot	;



        // the method is called recursively until all requests in the system entered
        // the critical session
        return runRaymondAlg( result )	;
    }

    // saveSystemState() saves the current system's state to the system file.
    // The content is saved in a certain format.
    private void saveSystemState() {
        String systemState = new String()	;
        for ( int i = 1; i < NUM_OF_NODES; i++ ) {
            Node node = ( Node ) _system.get ( i )	;
            systemState += node.getName() ;
            systemState += DELIMITER	;
            systemState += node.getTokenStatus()	;
            systemState += DELIMITER	;
            systemState += node.getHolderVariable()	;
            systemState += DELIMITER	;
            systemState += node.getRequestQueue()	;
        }
        writeString( SYSTEM_FILE, systemState )	;
    }
    // writeString() writes a given string to the file.
    private void writeString(String fileName, String s) {
        try {
            FileOutputStream out = new FileOutputStream( fileName );
            BufferedWriter fwriter = new BufferedWriter(new OutputStreamWriter(out));
            fwriter.write(s);
            fwriter.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    // readString() returns the given file's contents as a string.
    private String readString( String fileName ) {
        String returnStr = null;
        try {
            FileInputStream in =  new FileInputStream( fileName );

            BufferedReader freader = new BufferedReader(new InputStreamReader(in));

            String readStr = null;
            while ( ( readStr = freader.readLine() ) != null ) {
                if ( returnStr == null ) {
                    returnStr = readStr;
                    returnStr += "\n"	;
                }
                else {
                    returnStr += readStr;
                    returnStr += "\n"	;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println( fileName + " not existed" )	;
            return returnStr	;
        }
        catch (Exception e) {
            e.printStackTrace()	;
        }

        return returnStr;
    }
}
