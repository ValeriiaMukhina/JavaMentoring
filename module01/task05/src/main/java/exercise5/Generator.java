package exercise5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {

    private char[] charset;

    private int min; //var added for min char length
    private int max; //var added for max char length

    public Generator() {
        charset = "abc".toCharArray();

        //charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        min = 1; //char min bruteForce
        max = 3; //char max end
    }

    private void generateCombinations(int combinationLength, List<String> possibleValues)
    {
        int carry;
        int[] indices = new int[combinationLength];
        do
        {
            StringBuffer sb = new StringBuffer();
            for(int index : indices)
                sb.append(possibleValues.get(index));
            System.out.println(sb.toString());

            carry = 1;
            for(int i = indices.length - 1; i >= 0; i--)
            {
                if(carry == 0)
                    break;

                indices[i] += carry;
                carry = 0;

                if(indices[i] == possibleValues.size())
                {
                    carry = 1;
                    indices[i] = 0;
                }
            }
        }
        while(carry != 1); // Call this method iteratively until a carry is left over
    }

    public static void main(String[] args) {
        Generator bruteforce = new Generator();
        List<String> possibleValues = Arrays.asList("a", "b", "c");

        //for (int length = bruteforce.min; length < possibleValues.size(); length++) // Change bruteforce.min and bruteforce.max for number of characters to bruteforce.
            bruteforce.generateCombinations(3, possibleValues); //prepend_string, pos, length
    }
}
