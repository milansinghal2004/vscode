    class thread_join implements Runnable
    {
        public void run()
        {
            for(int i=0; i<5; i++)
            {
                System.out.println("Thread " + Thread.currentThread().getName() + " running");
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " exiting!");
        }
    
    public static void main(String[] args)
    {
        thread_join r1 = new thread_join();
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r1, "t2");
        Thread t3 = new Thread(r1, "t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
        } catch(Exception e) {
            System.out.println("Exception caught :)");
        }
    }

}