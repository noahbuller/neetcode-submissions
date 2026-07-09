class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(!(Character.isLetterOrDigit(s.charAt(i))) && j > i){
                i++;
            }
            while(!(Character.isLetterOrDigit(s.charAt(j))) && j > i){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;

        }    
        return true;
    }
     public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
