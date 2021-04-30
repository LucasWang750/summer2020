package Quiz2;

public class Part1
{
    int getHighestValue(int[] numList) {
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

    int getSecondHighestValue(int[] numList)
    {
        int max = getHighestValue(numList);
        int secondMax = numList[0];
        int length = numList.length;

        for (int i = 0; i < length; i++)
        {
            if(secondMax < numList[i] && numList[i] != max)
            {
                secondMax = numList[i];
            }
        }
        return secondMax;
    }
}
