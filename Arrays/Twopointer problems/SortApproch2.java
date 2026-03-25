public class SortApproch2 {

    static void swap(int arr[], int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void Sortingtech(int arr[]){
        int n = arr.length;
        int left = 0 , right =  n - 1 ;
        while(left < right){
            if(arr[left]==1 && arr[right]==0){
             swap(arr, left, right);
            }
           if(arr[left]==0){
            left++;
           }
           if(arr[right]==1){
            right--;
           }
        }

    }
    public static void main(String[] args) {
        int arr [] ={1,0,0,1,1,0,1,0,1};
        Sortingtech(arr);
        for(int num : arr){

            System.out.print(num);
        }
    }
}
