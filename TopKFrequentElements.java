// Need To Be Complete
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 

        for(int i = 0; i < nums.length; i ++) {
        	int num = nums[i]; 
        	Integer times = map.get(num); 
        	if(times == null) {
        		map.put(num, 1); 
        	}
        	else {
        		map.put(num, times + 1); 
        	}
        }

        Node[] nodes = new Node[map.size() + 1];
        int i = 1; 
        for(Integer key : map.keySet()) {
        	nodes[i] = new Node(key, map.get(key));
        	i ++;  
        }

        List<Integer> res = new ArrayList<Integer>(); 
        // heap sort
        int length = nodes.length - 1; 
        for(int j = 0; j < k; j ++) {
        	for(i = length; i > 1; i--) {
        	    if(nodes[i].num > nodes[i/2].num) {
        		    nodes[0] = nodes[i];
        		    nodes[i] = nodes[i/2]; 
        		    nodes[i/2] = nodes[0]; 
        	    }
            }

            // swap
            nodes[0] = nodes[1]; 
            nodes[1] = nodes[length]; 
            nodes[length] = nodes[0]; 

            res.add(nodes[length].val); 

            length --; 
        }

        return res;

    }


    public class Node {
    	int val; 
    	int num; 

    	public Node() {
    		val = 0; 
    		num = 0;
    	}

    	public Node(int val, int num) {
    		this.val = val;
    		this.num = num; 
    	}
    }
}