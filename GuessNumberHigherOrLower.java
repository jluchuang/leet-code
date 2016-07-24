/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int top = n; 
        int bottom = 1; 
        while (true) {
            int mid = bottom + (top - bottom) / 2;
            
            int res = guess(mid);
            
            if(res == 0) {
                return mid; 
            }
            
            if(res == -1) {
                top = mid - 1; 
            }
            else {
                bottom = mid + 1;   
            }
        }
        
    }
}