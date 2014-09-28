class Solution{
public:
	vector<string> restoreIpAddresses(string s) {
		vector <string> res;
		if(s.length()>15) return res;
		string str;
		for(int i=1; i<s.length()&&i<=3;i++){
			if(s.substr(0,i).compare("0")==0){
				str += s.substr(0,i);
				dfs(i,1,s,str,res);
				str.clear(); 
				break;
			}
			if(i<3||
				s.substr(0,i).compare("256")<0){
					str += s.substr(0,i);
					dfs(i,1,s,str,res);
					str.clear(); 
			}
			else{
				break;
			}
		}
		return res;
	}
private:
	void dfs(int pos, int dots, 
		const string &s, string &str, std::vector<string> &res){
			int left = s.length()-pos;
			if((4-dots)*3<left||pos==s.length()){
				return;
			}

			int temp = str.length();
			if(dots == 3){
				int lastLen = s.length()-pos;
				bool isOK = false;
				if(lastLen == 1){
					isOK = true;
				}
				else if(lastLen == 2&&s[pos] != '0'){
					isOK = true;
				}
				else if(lastLen == 3){
					if((s.substr(pos,s.length()-pos).compare("256")<0&&
						s[pos]!='0')){
							isOK = true;
					}
				}

				if(isOK){
					str += ".";
					str += s.substr(pos,s.length()-pos);
					res.push_back(str);
					str = str.substr(0,temp);  
				}
			}
			else{
				for(int i=1; pos+i<s.length()&&i<=3;i++){
					if(s[pos]=='0'){
						str += ".";
						str.insert(str.end(),s[pos]);
						dfs(pos+i,dots+1,s,str,res);
						str = str.substr(0,temp); 
						break;
					}
					if(i<3||
						s.substr(pos,i).compare("256")<0){
							str += ".";
							str += s.substr(pos,i);
							dfs(pos+i,dots+1,s,str,res);
							str = str.substr(0,temp); 
					}
					else{
						break;
					}
				}
			}
	}
};
