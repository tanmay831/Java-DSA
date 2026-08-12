class RunnableThreadA implements Runnable{
    public void run(){
        try{ 
            for(int i = 0; i<=10;i++){
          System.out.println("tanmay");
          
        }

        } finally{
            System.out.println("thread is completed");
    }
}
}

public class muliti {
    public static void main(String[] args) {
        RunnableThreadA r = new RunnableThreadA();
        Thread t = new Thread(r);
        t.start();
    }
}

