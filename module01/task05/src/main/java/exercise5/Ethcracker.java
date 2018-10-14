package exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Ethcracker {
        enum Status{working,done,err};

    List<String> possibleValues = Arrays.asList("a", "b", "c");
        protected int waitTimeMs = 1000;
        protected ExecutorService executor;
        protected ArrayBlockingQueue<String> pws;
        protected String foundPassword = null;
        protected AtomicInteger triedPasswds = new AtomicInteger(0);
        protected Status status = Status.working;
        protected boolean producerdone = false;
    private static String password = "cab";
    private static String hashedPassword = new HashCalculator().hash(password);

        class Consumer implements Runnable {
            public void run() {
                try {
                    while(status == Status.working){
                        String pw = pws.poll(waitTimeMs, TimeUnit.MILLISECONDS);
                        if(pw == null)
                            continue;
                        if(test(pw)){
                            foundPassword = pw;
                            status = Status.done;
                        }
                        else{
                            int n = triedPasswds.incrementAndGet();
                                System.out.print("Tried passwords: "+n + "\r");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    status = Status.err;
                }
            }
        }

        class Producer implements Runnable {
            int arraySize;
            Producer() {}

            Producer(int arraySize) {
                this.arraySize = arraySize;
            }

            public void run() {
                try{
                    while(status == Status.working){
                        generateCombinations(arraySize,possibleValues);

                            if(status == Status.done)
                                return;

                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                    status = Status.err;
                }
                finally{
                    producerdone = true;
                }
            }



            private void generateCombinations(int arraySize, List<String> possibleValues) throws InterruptedException {
                int carry;
                int[] indices = new int[arraySize];
                do
                {
                    StringBuffer sb = new StringBuffer();
                    for(int index : indices)
                        sb.append(possibleValues.get(index));
                    pws.offer(sb.toString(), waitTimeMs, TimeUnit.MILLISECONDS);

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

        }

        public Ethcracker()  {
            executor  = Executors.newFixedThreadPool(8);
            pws = new ArrayBlockingQueue<String>(100);
        }

        public void run() {
            for(int i=0; i< possibleValues.size(); i++) {
                executor.execute(new Producer(i));
            }
            for(int i=0; i< 4; i++){
                executor.execute(new Consumer());
            }
            //running tasks finish after shutdown
            executor.shutdown();

            while(!executor.isTerminated()){
                try {
                    if(producerdone && pws.isEmpty())
                        status = Status.done;
                    Thread.sleep(waitTimeMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    status = Status.err;
                }
            }
            if(foundPassword != null){
                System.out.println("\nFOUND PASSWORD:\t" + foundPassword);
            }
            else
                System.out.println("\nPASSWORD NOT FOUND in " +triedPasswds + " attempts");

        }

        public boolean test(String pw) throws InterruptedException{
                String hash = new HashCalculator().hash(pw);
               return hashedPassword.equals(hash);
        }


        public static void main(String[] args){
            try {

                Ethcracker ec = new Ethcracker();
                ec.run();
                if(ec.status == Status.err){
                    final int retcode = 4;
                    System.out.println("Exiting with error. retcode "+retcode);
                    System.exit(retcode);
                }
                if(ec.foundPassword == null)
                    System.exit(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(3);
            }
        }
    }
