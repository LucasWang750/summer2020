package Quiz2;

import java.util.ArrayList;

public class Driver
{


    public static void main(String[] args)
    {
        System.out.println("Part1-------------------------------------");
        int[] test = new int[] {10,3,7,2,8,7,7,1,2,10,10};
        System.out.println("Highest Value: " + getHighestValue(test));
        System.out.println("Second Highest Value: " + getSecondHighestValue(test));

        System.out.println("Part2-------------------------------------");
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(3);
        list.displayList();
        System.out.println("Max Value: " + list.getMaxValue());
        System.out.println("Index of 0: " + list.getIndex(0));
        System.out.println("Index of 4: " + list.getIndex(4));
        System.out.println("Index of 1: " + list.getIndex(1));


        System.out.println("Part3--------------------------------------");
        System.out.println("Highest Number of Occurences: " + getHighestNumberOfOccurences(test));
        System.out.println("Value of Highest Number of Occurences: " + getTheValueHasHighestNumberOfOccurences(test));
    }


    public static int getHighestNumberOfOccurences(int[] numList)
    {
        int[] newArr = makeNewArray(numList);
        return getHighestValue(newArr);
    }

    public static int[] makeNewArray(int[] numList)
    {
        int length = numList.length;
        int[] newArr = new int[length];

        for(int i = 0; i < length; i++)
        {
            int count = 1;
            for(int j = i+1; j < length; j++)
            {
                if(numList[i] == numList[j])
                {
                    count++;
                    newArr[j] = -1;
                }
            }
            if(newArr[i] != -1) {
                newArr[i] = count;
            }
        }
        return newArr;
    }

    public static int getTheValueHasHighestNumberOfOccurences(int[] numList)
    {
        int[] newArr = makeNewArray(numList);
        print(numList,newArr);
        for(int i = 0; i < numList.length; i++)
        {
            if(newArr[i] == getHighestValue(newArr))
            {
                return numList[i];
            }
        }

        return -1;
    }

    public static void print(int[] numList, int[] newArr)
    {
        for(int i = 0; i<numList.length;i++)
        {
            System.out.println(numList[i] + "|" + newArr[i]);
        }
    }

    public static int getHighestValue(int[] numList)
    {
        int max = numList[0];
        int length = numList.length;

        for (int i = 0; i < length; i++)
        {
            if(max < numList[i])
            {
                max = numList[i];
            }
        }

        return max;
    }

    public static int getSecondHighestValue(int[] numList)
    {
        int max = getHighestValue(numList);
        int secondMax = Integer.MIN_VALUE;
        int length = numList.length;

        for (int i = 0; i < length; i++)
        {
            if(secondMax < numList[i] && numList[i] != max)
            {
                secondMax = numList[i];
            }
        }

        if(secondMax == Integer.MIN_VALUE)
        {
            return max;
        }
        return secondMax;
    }

}
