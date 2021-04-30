package com.company;

public class Main {

    public static void main(String[] args) {
        boolean test1 = isPalindrome("HANNAH");
        System.out.println("test1 is " + test1);
        boolean test2 = isPalindrome("lol");
        System.out.println("test2 is " + test2);
        boolean test3 = isPalindrome("HELLO HELLO");
        System.out.println("test3 is " + test3);
    }

    public static boolean isPalindrome(String givenWord)
    {
        int length = givenWord.length();
        char[] wordArray = givenWord.toCharArray();
        int left = 0;
        int right = length-1;

        while(left < right)
        {
            if(wordArray[left] != wordArray[right])
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
