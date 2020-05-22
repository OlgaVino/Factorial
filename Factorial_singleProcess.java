import java.util.Date;

public class Factorial_singleProcess {

    private Factorial_singleProcess(){

    }
    private long factorial(long n) {
        if (n == 0){
            return 1;
        }
        if(n == 1) {
            return n;
        }
        return n*factorial(n-1);

    }

    public static void main(String[] args) {

//calculating value of 20! using 4 thread processes:
        Date beg = new Date();
        long number = 20;
        String num = String.valueOf(number);

        Factorial_singleProcess f = new Factorial_singleProcess();
        long result = f.factorial(number);

        System.out.println(num + "!= " + result);

        Date end = new Date();
        System.out.println("calculated in:" +(end.getTime()-beg.getTime()));
    }
}

