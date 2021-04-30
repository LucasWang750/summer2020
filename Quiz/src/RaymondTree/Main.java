package RaymondTree;
import java.io.*;

public class Main
{
    private static final boolean SUCCESS = true;
    private static final String DELIMITER = ";"	;
    private static treeBasedME system = new treeBasedME()	;
    private static String requests = null	;

    public static void main (String[] args)
    {
        system.setupTreeStructure();
        menu() ;
        while ( handleCommand( getUserInput() ) )
            menu() ;
    }


    public static void menu()
    {
        System.out.println( "Enter 1 ..................... Enter requests" )	;
        System.out.println( "Enter 2 ..................... View The Current System State" )	;
        System.out.println( "Enter 3 ..................... Run The Requests " )	;
        System.out.println( "Enter 0 ..................... Quit " )	;
    }

    public static String getUserInput()
    {
        BufferedReader userInput =
                new BufferedReader( new InputStreamReader( System.in ) )	;
        try {
            System.out.print( "? " )	;
            return userInput.readLine() 	;
        }
        catch( IOException e ) {
            e.printStackTrace() 	;
            return null	;
        }
    }

    private static void getRequests()
    {
        String requestId	;
        requests = new String()	;
        boolean isDone = false	;

        while ( !isDone ) {
            System.out.print( "Enter a request id (0 to end): " )	;
            requestId = getUserInput() ;
            if ( requestId.compareTo( "0" ) != 0 ) {
                requests += requestId	;
                requests += DELIMITER	;
            }
            else
                isDone = true	;
        }
    }

    public static boolean handleCommand( String userInput )
    {
        int command = Integer.parseInt( userInput ) 	;

        switch( command ) {
            case 1:
                getRequests()	;
                system.updateTreeStructure(requests)    ;
                return SUCCESS	;
            case 2:
                System.out.println( system.currentTreeStructure())  ;
                return SUCCESS	;
            case 3:
                System.out.println(system.executeRequests()) 	;
                return SUCCESS	;
            case 0:
                return !SUCCESS	;
            default:
                System.out.println( command + " is not existed ??? " );
                return SUCCESS	;

        }
    }
}
