class Solution {
    public int countDigits(int num) {
        int n=num,res=0;
        while (n!=0){
            res+=(num%(n%10)==0)?1:0;
            n/=10;
        }
        return res;      
    }
}