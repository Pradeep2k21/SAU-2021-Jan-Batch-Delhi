import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitandNotify {

        Queue<Integer> items = new LinkedList<>();


        int sizeOfBucket=4;
        
        public void producer() throws InterruptedException
        {
            int count=1;
            System.out.println("**************In producer function*************** \n");

            while(true)
            {
                synchronized (this)
                {
                    // producer thread waits while list is full
                    while(items.size()==sizeOfBucket){
                        System.out.println("Bucket Size Overflow\n");
                        wait();
                    }

                    System.out.println("produces  item number  : "+ count +"\n");
                    count = count + 1;
                    items.add(count);

                    // notifies the consumer thread that now it can start consuming
                    notify();
                    // sleep
                    Thread.sleep(1500);
                }
            }
        }
        
        public void consumer()
        {
            try {
                while(true)
                {
                    synchronized (this)
                    {

                        while(items.size()==0) {         // consumer thread waits while our bucketsize is zero
                            System.out.println("\nEmpty Bucket list\n");
                            wait();
                        }
                        System.out.println("consumed item number: "+ items.remove());

                        // Wake up producer thread
                        notify();
                        //sleep
                        Thread.sleep(1000);
                    }
                }
            }
            catch(Exception exception){
                System.out.println("Exception occur");
            }
        }
        
    public static void main(String[] args)  {


        System.out.println("In main class \n");

        ProducerConsumerUsingWaitandNotify Obj;
        Obj = new ProducerConsumerUsingWaitandNotify();


        Thread pThread = new Thread(new Runnable() {   // Create thread for producer

            @Override
            public void run() {  //The run() method  here is because thread was constructed
                                // using a separate Runnable object otherwise this method does nothing and returns.
                try {
                    Obj.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create thread for consumer
        Thread cThread = new Thread(new Runnable() {

            @Override
            public void run() {  //The run() method  here is because thread was constructed
                // using a separate Runnable object otherwise this method does nothing and returns.
                try {
                    Obj.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            // starting threads

            pThread.start();
            cThread.start();


            pThread.join();   // use join so that our main function not execute first
            cThread.join();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
