//1️⃣ Find Pair with Given Sum (Two Sum – Basic)

//Problem:
//Given array and target, find two numbers whose sum = target.

//Input: arr = [2,7,11,15], target = 9  
//Output: [2,7]


public class FindPair {

    static void firstpair(int arr []){
        int target = 9;
        int n = arr.length;
        
       for(int i = 0;i < n;i++){
        for(int j = i + 1;j < n ; j++){
            if(arr[i]+arr[j]==target){
               System.out.println(arr[i]+" "+arr[j]);
              return ;  
            }
        }
    }  
     System.out.println("No pair found");
}
     
        
    
    
    public static void main(String[] args) {
        int arr [] ={2,7,11,15};

        firstpair(arr);
    }
}
