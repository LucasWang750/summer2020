package Final;

import java.io.*;


public class FileUtility
{
    public FileUtility()
    {
    }

    public BufferedReader getFile(File file)
    {
        FileInputStream fis = null;
        BufferedReader br = null;

        try
        {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            return br;
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

        return br;
    }

    // To return the output stream object which can be used to write the object to a file
    public ObjectOutputStream getObjectOutputStream(File outputLocation)
    {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try
        {
            if (!outputLocation.exists())
            {
                outputLocation.createNewFile();
            }

            fout = new FileOutputStream(outputLocation);
            oos = new ObjectOutputStream(fout);
            return oos;
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return oos;

    }

    // To return the input stream object which can be to read the object from a file
    public ObjectInputStream getObjectInputStream(File inputLocation)
    {
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try
        {
            fin = new FileInputStream(inputLocation);
            ois = new ObjectInputStream(fin);

            return ois;
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return ois;
    }
}
