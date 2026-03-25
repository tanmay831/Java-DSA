public class SortingEven_odd {
static void swap(int arr[],int a , int b){
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
static void Sorting_Even(int arr []){
    int n = arr.length;
    int left = 0; int right= n-1;
    while (left <  right ){
       
        if(arr[left] % 2 ==1 && arr[right]%2==0){
             swap(arr, left, right);
            left ++;
            right --;
        }           
             if(arr[left] % 2 == 0){
                left++;
             }
             if(arr[right] % 2 == 1){
                right--;
             }
        }
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Sorting_Even(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
    
}
