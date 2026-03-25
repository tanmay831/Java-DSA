//Squares of a Sorted Array

public class SquaredSort {

    
    static int [] sortedSquares(int arr[]){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int []ans = new int [n];
        int k = n - 1 ; // start from the end 
        
        while(left <=  right){
          if(Math.abs(arr[left]) > Math.abs(arr[right])){
            ans[k--] = arr[left]*arr[left];
            left++;
          }else{
              ans[k--]=arr[right]*arr[right];
              right--;
          }
    }return ans;
}
    public static void main(String[] args) {
        int arr [] = {-4,-1,0,3,10};
       int result[]= sortedSquares(arr);

        for(int num : result){
            System.out.print(num +" ");
        }
    }
}
