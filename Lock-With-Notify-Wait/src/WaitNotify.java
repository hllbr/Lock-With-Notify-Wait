
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WaitNotify {
    private Object lock = new Object();
    
    public void thread1fonksiyon(){
        synchronized(lock){
            System.out.println("birinci anahtar devrede...!");
            System.out.println("birinci anahtar ikinci anahtarın uyanmasını bekliyor..");
            
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                System.out.println("Kesme/Uyuma/Uyutma Hatası Meydana geldi.");
            }
            System.out.println("bir numaralı anahtar aktif durumdu işemlerini devam ettiriyor...!");
        }
          
    }
    public void thread2fonksiyon(){
        Scanner scn = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("Uyku hatası meydana geldi");
        }
        synchronized(lock){
            System.out.println("ikinci anahtar çalışma pozisyonunda.");
            System.out.println("işlemi sürdürmek için bir tuşa basınız : ");
            System.out.println("Lütfen anahtarı uyandırmak için -1 harici bir tuşlama yapınız");
            String tuslama = scn.nextLine();
              if(!(tuslama.equals("-1"))){
                lock.notify();
            }else{
                System.out.println("yapı sonsuz döngü meydana geldi lütfen programı resetleyiniz");
              
            }
          //  notify();
         //  System.out.println("akşamdan kalma moduna girildi.\nUyandırlması gereken kahve ile ayıldı.\nYapı görevini başarı ile icra etti");
        }
          
        }
    }

