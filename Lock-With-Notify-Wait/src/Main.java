
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               wn.thread1fonksiyon();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               wn.thread2fonksiyon();
            }
        });
        t1.start();
        t2.start();
        
        try {    
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println("InterruptException meydana geldi");
        }
    
    }
    
}
