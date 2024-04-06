class Solution {
    public String minRemoveToMakeValid(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;

        String result;
        char[] arr = s.toCharArray();
        int openParenthesesCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                openParenthesesCount++;
            else if (arr[i] == ')') {
                if (openParenthesesCount == 0)
                    arr[i] = '*'; 
                else
                    openParenthesesCount--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (openParenthesesCount > 0 && arr[i] == '(') {
                arr[i] = '*'; 
                openParenthesesCount--;
            }
        }
                int p = 0; 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }
        result = new String(arr).substring(0, p);

        return result;
    }
}