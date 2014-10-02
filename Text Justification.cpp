#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
    	std::vector<string> res;
    	if(words.empty()) return res;

    	int i=0;
    	while(i<words.size()){
    		
    		int totalLen = words[i].length();
    		int j=i+1;

    		while((j<words.size())&&
    			     (totalLen+words[j].length()+j-i)<=L){
    			totalLen += words[j].length();
    			j++;     			
    		}

    		if(j==words.size()){
    			break;
    		}
    		else{
    			string line = adjustOneLine(words, i, j-1, totalLen, L);
    			res.push_back(line);
    		}

    		i = j;
    	}

    	//Deal the last Line
    	if(i<words.size()){
    		string line;
    		line += words[i++];
    		while(i<words.size()){
    			line += " ";
    			line += words[i++];
    		}    		
    		int j = line.length();
    		while(j<L){
    			line.insert(line.end(),' ');
    			j++;
    		}
    		res.push_back(line);
    	} 

    	return res;
    }
private:
	string adjustOneLine(vector<string> &words, 
		                 int beg, 
		                 int end,
		                 int totalLen,  
		                 const int L){
		string line;
		line += words[beg]; 

		//Deal the case that only one word in a line.
		//Fill the right of the word with spaces. 
		if(beg == end){
		    int i=line.size();	
			for(;i<L;i++){
				line.insert(line.end(),' ');
			}
			return line;
		}

        int extraSpaces = L-totalLen;

		int evenly = extraSpaces/(end-beg);
		int remain = extraSpaces%(end-beg);

        //Generate a string filled with evenly spaces
		string spaces;
		for(int i=0; i<evenly; i++){
			spaces +=" ";
		}

        //Generate one line
        int k=0; //The first k should insert more spaces  
		for(int i=beg; i<end; i++){
			line += spaces;
			if(k<remain){
				line.insert(line.end(),' ');
				k++;
			}
			line += words[i+1]; 
		}

		return line;
	}
};

int main(){
	Solution ss;
	std::vector<string> v;
	//v.push_back("This");
	//v.push_back("is");
	//v.push_back("an");
	//v.push_back("example");
	//v.push_back("of");
	//v.push_back("text");
	//v.push_back("justification.");
	v.push_back("");
	vector <string> res = ss.fullJustify(v,0);
	for(int i=0; i<res.size(); i++){
		cout<<res[i]<<endl;
	}
	return 0;
}
