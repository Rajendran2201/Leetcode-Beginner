class Solution {
    public boolean isValid(String word) {
        boolean isValid = true;
        if(word.length() < 3){
            isValid = false;
        }

        boolean containsVowel = false, containsCons = false;

        HashSet<Character> vowels = new HashSet<>();

        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowels.add(ch);
        }

        for(char c: word.toCharArray()){
            if(Character.isLetter(c)){
                if(vowels.contains(c)){
                    containsVowel = true;
                }else{
                    containsCons = true;
                }
            }else if(Character.isDigit(c)){
                continue;
            }else{
                isValid = false;
            }
        }

        if(!containsVowel || !containsCons){
            isValid = false;
        }


        return isValid;
    }
}