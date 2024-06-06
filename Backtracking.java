public class Backtracking {
    public static void changeArr(int arr[], int i, int val){
        //base condition
        if(i == arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1); //function call step
        arr[i] = arr[i] -2; //backtracking step
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }  


    //FINDING SUBSET
    public static void findSubset(String str, String ans, int i){
        //base case
        if(i == 0){
            System.out.println("null");
        }else{
            System.out.println(ans);
        }
        return;
    }

    //FINDING PERMUTATION
    public static void findPermutation(String str, String ans){
       
        if(str.length() == 0){
            System.out.println(ans);
        }

        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }

    
    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}
