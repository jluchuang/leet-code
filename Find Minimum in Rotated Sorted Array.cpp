//@Author: chuang
//@time: 16/10/2014
//Find Minimum in Rotated Sorted Array
//Idea: Binary Search
class Solution {
public:
	int findMin(vector <int> &num) {
		int head = 0;
		int tail = num.size()-1;
		while(head < tail){
		    //the array is sorted then return the smallest
			if(num[head]<num[tail]){
				return num[head];
			}
			
			int mid = (head+tail)/2;
			//sorted from head to mid
			//the smallest must in the mid+1..tail
			if(num[head]<=num[mid]){
				head = mid+1;
			}
			//smallest must in head..mid
			else{
				tail = mid;
			}
		}
		return num[head];
	}
};
