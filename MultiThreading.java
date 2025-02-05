import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Example uasge of ThreadPool
class MultiThreading implements Runnable {
    int taskId;

    public MultiThreading(int id){
        taskId = id;
    }

    @Override
    public void run(){
    
        System.out.println("taskId: "+taskId+"ThreadId: " +Thread.currentThread().getId());
        
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        
        System.out.println("task : "+taskId +" completed" + "thread "+ Thread.currentThread().getId());   
            
    }
}
class Main {
    public static void main(String[] args) {
        int n=3;

        // Initialize thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(n);
        for(int i=0;i<6;i++){
            // spawn new thread
            executor.execute(new MultiThreading(i));
            
        }
        
        executor.shutdown();
    }
}
