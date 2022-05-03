
import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
    private int IdClinte;
    private Semaphore semaforo;
    private static int TOTAL_DE_ESPERA = 5;
    private static int TOTALTEMPOEMPERA = 5;

    public  Cliente(int IdClinte , Semaphore semaforo){
        this.IdClinte = IdClinte;
        this.semaforo = semaforo;
        start();
    }
    
    public synchronized void Esperando_Atentimento(){
        int contador = 0;

        while(contador < TOTALTEMPOEMPERA){
            int rodada = 1;
            contador += rodada;
            System.out.println("O Cliente # " + IdClinte + " Esperando Atendimento ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Atendido(){
        System.out.println("O Cliente # " + IdClinte + " Foi Atendido ");
    }

    public synchronized  void Aguardando_Pedido(){
        int contador = 0;

        while(contador < TOTAL_DE_ESPERA){
            int rodada = 1;
            contador += rodada;
            System.out.println("O Cliente # " + IdClinte + " Aguardando o Pedido");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void Recebeu_Pedido(){
        System.out.println("O Cliente # " + IdClinte + " Recebeu o Pedido ");
    }

    public synchronized void Comendo(){
        for(int i = 1 ; i <= 3; i++){
            int rodada = 1;
            rodada += rodada;
           System.out.println("O Cliente # " + IdClinte + " Comendo ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Terminou_De_Comer(){
        System.out.println("O Cliente # " + IdClinte + " Terminou de Comer ");
        
    }

    public  void run(){
        Esperando_Atentimento();
        Atendido();
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            Aguardando_Pedido();
            Recebeu_Pedido();
            Comendo();
            Terminou_De_Comer();
            
        }
    }

}
