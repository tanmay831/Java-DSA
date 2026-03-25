public class Problem2 {
   static int Maximum(int arr[]){
      int n = arr.length;
      int mx = Integer.MIN_VALUE;
      for(int i = 0; i < n;i++){
        if(arr[i] > mx){
            mx = arr[i];
        }
      }
      return mx;
   }
   static int Minimum(int arr[]){

    int n = arr.length;
    int mn = Integer.MAX_VALUE;
    for(int i = 0; i < n ; i++){
        if(arr[i] < mn){
          mn = arr[i];
        }
    }
    return mn;
   }

    public static void main(String[] args) {
        int arr [] = {3,7,9,2,1};
        int result = Maximum(arr);
        int result2 = Minimum(arr);
        System.out.println(result +" " + result2);
    }
}
