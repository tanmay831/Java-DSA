public class swapping {
     static void swap(int a , int b){
        System.out.println("value of before swapping");
        System.out.println("value of a : "+ a);
        System.out.println("value of b :"+ b);

        System.out.println("Value after swapping ");
          
        int temp = a;// here temp get the value 9 
        a = b;
        b =  temp ;
        
        System.out.println("value of a :"+ a);
        System.out.println("value of b :"+ b);
     
     }
    
        
    
    public static void main(String[] args) {

        int a = 3;
        int b = 9 ;

        swap(a, b);
        
    }
}
