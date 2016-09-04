public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder(); 
        n = n - 1;
        while (true) {
            int tmp = n % 26;
            char a = (char)('A' + tmp); 
            sb.append(a); 
            n = n /26;
            if(n != 0) {
                n = n - 1; 
            }
            else {
                break; 
            }
        }
        return sb.reverse().toString(); 
        
    }
}