package exercise5;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Generator1 implements Runnable{


    List<String> possibleValues;
    int length;
    private static BlockingQueue<String> queue;
    static boolean isCracked;

    public Generator1(int length, List<String> possibleValues, BlockingQueue<String> queue, boolean isCracked) {
       this.length = length;
       this.possibleValues = possibleValues;
       this.queue = queue;
       this.isCracked = isCracked;
    }

    private void generateCombinations(int arraySize, List<String> possibleValues) throws InterruptedException {
        int carry;
        int[] indices = new int[arraySize];
        do
        {
            if(isCracked) return;
            StringBuffer sb = new StringBuffer();
            for(int index : indices)
                sb.append(possibleValues.get(index));
            System.out.println(sb.toString());
            queue.offer(sb.toString(), 100, TimeUnit.MILLISECONDS);
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
        while(carry != 1 && !isCracked);
    }

    public void run() {
        try {
            generateCombinations(length, possibleValues);
        }catch  (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
