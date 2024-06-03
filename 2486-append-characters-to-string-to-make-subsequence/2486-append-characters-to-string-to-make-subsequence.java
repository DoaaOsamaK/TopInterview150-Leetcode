class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        int c=0;
        while(i<s.length()&&j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }else{
                i++;
            }
        }
        return t.length()-j;
    }}