class Solution {
    public String largestOddNumber(String num) {
        int j = num.length() - 1;
        while(j >= 0){
            char ch = num.charAt(j);
            if((ch & 1) == 1)
                return num.substring(0, j+1);
            j--;
        }
        return  "";
    }
}