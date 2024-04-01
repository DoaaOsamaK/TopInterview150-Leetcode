class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.strip();
        int count=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==' ') return count;
            count+=1;
        }
        return count;
    }
}