class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int []a=new int[26];
        int []b=new int[26];

        Arrays.fill(a,0);
        Arrays.fill(b,0);

        for(int i=0;i<ransomNote.length();i++)
        {
            a[ransomNote.charAt(i)-97]++;
        }

        for(int i=0;i<magazine.length();i++)
        {
            b[magazine.charAt(i)-97]++;
        }

        for(int i=0;i<26;i++)
        {
            if(a[i]>b[i])
            return false;
        }
        return true;
    }
}