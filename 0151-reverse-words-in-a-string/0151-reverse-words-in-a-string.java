class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" +");
        int i = 0, j = arr.length - 1;
        while(i < j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        String res =  String.join(" ", arr);
        return res;
    }
}