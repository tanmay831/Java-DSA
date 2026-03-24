class Calc {

    public static int add(int a , int b){
        return a + b;
    }

    public static int sub(int a , int b){
        return a - b;
    }
}

public class inheri {

    public static void main(String[] args) {

        int result = Calc.add(5 ,5);
        int result2 = Calc.sub(3 ,11);

        System.out.println(result + " " +  result2);
    }
}