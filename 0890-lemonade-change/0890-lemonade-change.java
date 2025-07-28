class Solution {
    public boolean lemonadeChange(int[] bills) {
        // each customer will onlybuy one lemonade
        // we need to track remaining amount
        // If 5 dollar is given, no issues. Add it to rem5
        // If 10 dollars is given, increment rem10 and decrement rem5 (if exists)
        // If 20 dollars are given, 
           //  - decrement rem5 and rem10 (if exists)
           // - decrement rem5 three times (give three 5 dollars)

        int rem5 = 0, rem10 = 0;
        for(int bill: bills){
            if(bill == 5){
                rem5++;
            }
            else if( bill == 10){
                if(rem5 > 0){
                    rem10++;
                    rem5--;
                }else{
                    return false;
                }
            }else if( bill == 20){
                if(rem5 > 0 && rem10 > 0){
                    rem5--;
                    rem10--;
                }else if(rem5 >= 3){
                    rem5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}