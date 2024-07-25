
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WaitNotify {
    
    
    private Object lock = new Object();
    
    public void thread1Fonksiyonu(){
        
        synchronized(lock){
            
            System.out.println("Thread 1 çalışıyor");
            System.out.println("Uyandırmanızı bekliyorum");
            
            try {
                //burada wait ile bekletiyoruz programı 
                //eğer wait var ise notfiy da olması gerekiyor.
                lock.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Uyandım Çalışıyorum");
        }
    }
    
    public void thread2Fonksiyonu(){
        
        synchronized(lock){
            System.out.println("Thread 2 çalışıyor");
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Uyandırılması için bir tuşa basınız");
            scanner.nextLine();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //burada devam ettiriyoruz fonksiyon bitince diğeri çalışıyor.
            System.out.println("Ben uyandırdım abi");
            lock.notify();
            
            
        }
    }
}
