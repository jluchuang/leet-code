//@Author: chuang
//@time: 16/10/2014
//Valid Parentheses
class Solution{
public:
	bool isValid(string s) {
		stack <char> st;
		int i = 0;
		for(; i<s.size(); i++) {
			if(s[i] == '(' || s[i] == '{' || s[i] == '['){
					st.push(s[i]);
			}
			else {
				if(st.empty()){
					return false;
				}
				else{
					char left = st.top();
					st.pop();
					if((left == '(' && s[i] == ')') || 
					   (left == '{' && s[i] == '}') ||
					   (left == '[' && s[i] == ']')){
						continue;
					}
					else{
						return false;
					}
				}
			}
		}
		if(!st.empty()) return false;
		return true;
	}
};
