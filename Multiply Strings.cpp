//@Author: chuang
//@time: 19/10/2014
//Multiply Strings
//Idea: Basic String Operations
//      Simplify the problem to be two small problem
//      1)Multiply a string with a int 
//      2)Add two strings
//      Total Time O(nm)
class Solution{
public:
	string multiply(string num1,string num2){
		if(num1.compare("0") == 0||num2.compare("0") == 0){
			return "0";
		}
		string res;
		int weight = 0;
		for(int i = num1.size()-1; i>=0; i--){
			string tmp = multiply(num2,num1[i]-'0');
			int j = weight;
			while(j>0){
				tmp.insert(tmp.end(),'0');
				j--;
			}
			weight++;
			res = addTwoString(res,tmp);
		}
		return res;
	}
private:
	string multiply(string num1,int num2){
		if(num2 == 0){
			return "0";
		}
		int carry = 0;
		string res;
		for(int i = num1.size()-1;i>=0;i--){
			int multi = (num1[i]-'0')*num2+carry;
			carry = multi/10;
			res.insert(res.begin(),(multi%10+'0'));
		}
		if(carry > 0){
			res.insert(res.begin(),carry+'0');
		}
		return res;
	}
	string addTwoString(string num1,string num2){
		if(num1.compare("0")==0){
			return num2;
		}
		if(num2.compare("0")==0){
			return num1;
		}
		string res;
		int carry = 0;
		int len1 = num1.size()-1;
		int len2 = num2.size()-1;
		while(len1>=0&&len2>=0){
			int left = num1[len1--]-'0';
			int right = num2[len2--]-'0';
			int sum = left+right+carry;
			if(sum>=10){
				res.insert(res.begin(),sum-10+'0');
				carry = 1;
			}
			else{
				res.insert(res.begin(),sum+'0');
				carry = 0;
			}
		}
		while(len1>=0){
			int sum = num1[len1--]-'0'+carry;
			if(sum>=10){
				res.insert(res.begin(),sum-10+'0');
				carry = 1;
			}
			else{
				res.insert(res.begin(),sum+'0');
				carry = 0;
			}	
		}
		while(len2>=0){
			int sum = num2[len2--]-'0'+carry;
			if(sum>=10){
				res.insert(res.begin(),sum-10+'0');
				carry = 1;
			}
			else{
				res.insert(res.begin(),sum+'0');
				carry = 0;
			}	
		}
		if(carry>0){
			res.insert(res.begin(),'1');
		}
		return res;
	}
};

