public class Part1 {
    static int[] arrayList = new int[10];
    static int arrayListLength = 10;

    public static void main(String[] args)
    {
        int[] newArrayList = null;

        initializeArrayList();
        printArrayList(arrayList);
        newArrayList = reserveArrayList(arrayList);
        printArrayList(newArrayList);
    }

    // Implement this method to initialize the arrayList by USING the for...loop and
    // 1 or none local variable. After execute this method, the arrayList should have the
    // following values: [10,9,8,7,6,5,4,3,2,1].
    // It means the data in arrayList[0] is 10
    private static void initializeArrayList()
    {
        for(int i = 0; i < arrayListLength; i++)
        {
            arrayList[i] = arrayListLength - i;
        }
    }

    // Implement this method to return the new array list with the reverse order of
    // the given arrayList in the parameter by USING 1 for...loop and
    // 1 or none new local array. .
    // For example, if arrayList data is: 1, 2, 3, then it will return the new array
    // list with 3, 2, 1.
    private static int[] reserveArrayList(int[] arrayList)
    {
        int temp;
        // no use arrayListLength here because parameter?
        int backward = arrayListLength - 1;
        for(int forward = 0; forward < backward; forward++)
        {
            temp = arrayList[forward];
            arrayList[forward] = arrayList[backward];
            arrayList[backward] = temp;
            backward--;
        }
        return arrayList;
    }

    // Implement this method to print the list of values in the array in the parameter
    // by USING System.out.println.
    private static void printArrayList(int[] arrayList)
    {
        // no use arrayListLength here because parameter?
        for(int i = 0; i < arrayListLength; i++)
        {
            System.out.println("arrayList[" + i + "] = " + arrayList[i]);
        }
    }

}
