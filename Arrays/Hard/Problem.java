public class Problem {
   static int[] reverse(int arr[]){
    int n = arr.length;
    int ans [] = new int[n];  // [0,0,0,0,0] //j
    int j = 0 ;    

    for(int i = n -1;i >=0;i--){
        ans[j] = arr[i];
        j++;
    }
    return ans ;
    

   }
   
    public static void main(String args []){
        int arr [] = {1,2,3,4,5};
         int result [] = reverse(arr);
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
