package Input;

import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args)
    {
        String FILE_NAME = "in.txt";
        try
        {
            String line = null;

            File fin = new File("C:\\Users\\Lucas\\IdeaProjects\\Quiz\\" + FILE_NAME);

            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(fin)));

            line = reader.readLine();

            while(line != null)
            {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");

                while (stringTokenizer.hasMoreElements())
                {
                    String strExample = stringTokenizer.nextElement().toString().trim();;
                    System.out.println(strExample);
                }
                line = reader.readLine();
            }


            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
