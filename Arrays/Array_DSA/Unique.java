public class Unique {

    static int Uni(int arr []){
      
        int n = arr.length;

        for(int i = 0;i < n ; i++){
            for(int j = i+1;j<n;j++){         // means here all the same pair gets -1 
                if(arr[i]==arr[j]){           //
                    arr[i]=-1;
                    arr[j]=-1;
                }
            }
        }
        int ans = -1 ;// here we initizile the by -1.
        for(int i = 0; i < n; i++){
           if(arr[i]>0){
            ans = arr[i];
           }
        }
        return ans ;
        


    }
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,1,2,3};
        System.out.println(Uni(arr));
    }
}
