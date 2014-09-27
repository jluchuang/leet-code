//思路和最大子段和问题相似，但是乘法需要注意的是在因子的负号个数为偶数时乘积会出现整数
//所以保存到当前位置的局部最大乘积maxSoFar
//和到当前位置的局部最小乘积minSoFar

class Solution{
public:
	int maxProduct(int A[], int n){
		if(A==NULL||n<=0) return 0;

		int maxPro = A[0];
		int maxSoFar = A[0];
		int minSoFar = A[0];

		for(int i=1;i<n;i++){
			int tempMax = max(maxSoFar*A[i],max(minSoFar*A[i],A[i]));
			int tempMin = min(maxSoFar*A[i],min(minSoFar*A[i],A[i]));
			maxPro = max(tempMax,maxPro);
			maxSoFar = tempMax;
			minSoFar = tempMin;
		}

		return maxPro;
	}
};
