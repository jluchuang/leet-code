/*********************************************************************
** 1.find the turning point of the array using binary search
**    the turning point is the smallest element of the array
**    CASE 1:if A[mid]>=A[head] then the subarray A[head..mid]
**           is already in non descending order so we kown that
**        a.A[head] is the smallest one of A[head..mid]
**        b.the smallest one is min(A[head],min(A[mid+1..tail]))
**    CASE 2:if A[mid]<A[head] then the subarray A[mid..tail]
**           is already in nondescending order and
**          the smallest one is min(A[mid],min(A[head..mid-1]))
** 2.Denote the turning point with "pos"
**   binary search (A,0,pos-1) and (A,pos,n-1)
*********************************************************************/

class Solution{
public:
	int search(int A[], int n, int target){
		if(A==NULL||n<=0){
			throw "Invalid arguments!";
		}

		int pos = findPos(A, 0, n-1);

		int index = binarySearch(A, 0, pos-1, target);
		if(index != -1){
			return index;
		}

		return binarySearch(A, pos, n-1, target);
	}
private:
	int findPos(int A[], int head, int tail){
		if(head>tail){
			return -1;
		}

		int mid = (head+tail)/2;

		//sorted from head to mid
		if(A[mid]>=A[head]){
			int pos = findPos(A, mid+1, tail);

			if(pos == -1){
				return mid;
			}
			else{
				return A[pos]<A[head]?pos:head;
			}
		}
		else{
			int pos = findPos(A,head,mid-1);

			if(pos == -1){
				return mid;
			}
			else{
				return A[pos]<A[mid]?pos:mid;
			}
		}
	}
	int binarySearch(int A[], int head, int tail, int target){
		if(A[head]>target||A[tail]<target) return -1;

		while(head <= tail){
			int mid = (head+tail)/2;

			if(A[mid] == target){
				return mid;
			}
			else if(A[mid]>target){
				tail = mid-1;
			}
			else {
				head = mid+1;
			}
		}

		return -1;
	}
};
