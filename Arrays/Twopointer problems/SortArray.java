public class SortArray {
    static void CountZero(int arr[]){
        int n = arr.length;
        int zeros = 0;
        for(int i = 0; i < n; i++){
            if(arr[i]==0){
                zeros++;
            }
        }
        for(int i = 0;i < n;i++){
            if( i < zeros){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }

    }
    public static void main(String[] args) {
        int arr [] = {1,0,1,0,1,0,1,0,1};
          CountZero(arr);
        for(int num : arr){
            System.out.println(num);
        }
    }
}
