public class MultiThread {
    

        public static void main(String[] args) {
            
            Thread thread1 = new Thread(new Task());
            Thread thread2 = new Thread(new Task());
    
            thread1.start();
            thread2.start();
        }
    
        
        static class Task implements Runnable {
    
            @Override
            public void run() {
                try {
                    // Simulating task execution which might throw an exceptio
                    System.out.println(Thread.currentThread().getName() + " is starting.");
                    
                    // Simulating a runtime exception, like dividing by zero
                    int result = 10 / 0; // This will throw ArithmeticException
                    
                    System.out.println(Thread.currentThread().getName() + " result: " + result);
    
                } catch (ArithmeticException e) {
                    // Handle specific exception (like ArithmeticException)
                    System.err.println("Exception occurred in " + Thread.currentThread().getName() + ": " + e.getMessage());
                } catch (Exception e) {
                    // Handle any other generic exceptions
                    System.err.println("An unexpected error occurred in " + Thread.currentThread().getName() + ": " + e.getMessage());
                } finally {
                    System.out.println(Thread.currentThread().getName() + " finished execution.");
            }
        }
    }
}
    

