public class Solution {
    public String largestNumber(int[] nums) {
        List<String> ls = new ArrayList<String>(); 
        
        for(int i = 0; i < nums.length; i ++) {
            ls.add(String.valueOf(nums[i])); 
        }
        
        Collections.sort(ls, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s2.compareTo(s1);
            }
        }); 
        
        if(!ls.isEmpty() && ls.get(0).charAt(0) == '0') {
            return "0"; 
        }
        
        StringBuilder sb = new StringBuilder(); 
        for(String st : ls) {
            sb.append(st); 
        }
        
        return sb.toString(); 
    }
}