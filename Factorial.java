import java.util.Date;

public class Factorial extends Thread {
    private long subresult;
    private long n;
    private long middle;

   private Factorial(long N, long M){
       this.n = N;
       this.middle = M;
   }

    public void run() {
        subresult = this.factorial(n, middle);
    }

    private long factorial(long l, long m) {
        if (l == 0) {
            return 1;
        }
        if (l == m) {
            return l;
        }
        return l * factorial(l - 1, m);
    }

    public static void main(String[] args) throws InterruptedException{

//calculating value of 20! using 4 thread processes:
        Date beg = new Date(); //to start timer
        long number = 20;
        int PROCESS = 4;
        String num = String.valueOf(number);
        long b = Math.floorDiv(number, PROCESS);
        long result = 1;
        Factorial[] factorials = new Factorial[PROCESS];

            while (number > 0){
                for (int y=0; y< factorials.length; y++){
                    factorials[y] = new Factorial(number,number-b+1);
                    factorials[y].start();
                    number-=b;
                }
            }
            for (int y=0; y< factorials.length; y++){
                factorials[y].join();
                result*=factorials[y].subresult;
            }


        System.out.println(num + "! = " + result);
        Date end = new Date(); //to stop timer
        System.out.println("calculated in:" +(end.getTime()-beg.getTime()));
    }
}
