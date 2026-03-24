public class hello{
    public static void main(String args[]){
       int count=0;
       for(int i =1;i<=50;i++){
        if(i % 7== 0){
          count+=i;
        }
       }
       System.out.println(count);
    }
}