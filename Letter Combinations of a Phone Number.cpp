//@Author: chuang
//@time:17/10/2014
//Letter Combinations of a Phone Number
//Idea: dfs
class Solution{
public:
	vector <string> letterCombinations(string digits){
		std::vector<string> res;
		dfs(res,"",digits);
		return res;
	}
private:
	static const string digitsMap[] ;
	void dfs(vector <string> &res, string tmp,string digits){
		int tPos = tmp.size();
		if(tPos == digits.size()){
			res.push_back(tmp);
			return;
		}
		for(int i=0;i<digitsMap[digits[tPos]-'1'].size();i++){
			tmp.insert(tmp.end(),digitsMap[digits[tPos]-'1'][i]);
			dfs(res,tmp,digits);
			tmp = tmp.substr(0,tmp.size()-1);
		}
	}
};
const string Solution::digitsMap[] = {"", "abc", "def", 
	                            "ghi", "jkl", "mno",
	                            "pqrs", "tuv", "wxyz"};
