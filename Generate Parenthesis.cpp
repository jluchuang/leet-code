//@Author: chuang
//@time: 16/10/2014
//Generate Parenthrsis
//Idea: dfs, keep the prefix lns>=rns,
//      which lns denote the number of left parenthesis
//      and rns denote the number of right parentesis,
//      to make sure the tmp is eligible.
//      If lns>rns we can insert ")" into the tmp's end. 
class Solution {
public:
	vector <string> generateParenthesis(int n) {
		vector <string> res;
		string tmp;
		dfs(tmp, 0, 0, res, n);
		return res;
	}
private:
	void dfs(string tmp, int lns, int rns, vector <string> &res, int n){
		//find one solution
		if(lns == n){
			for(int i = rns; i<n; i++){
				tmp += ")";
			}
			res.push_back(tmp);
			return ;
		}
		dfs((tmp+"("), lns+1, rns, res, n);
		if(lns>rns){
			dfs((tmp+")"), lns, rns+1, res, n);
		}
	}
};
