//@Author: chuang
//@time: 17/10/2014
//ZigZag Conversion
//Idea: This problem is like a hash table for a string,
//      we hash the charactors of the string into another
//      string base on the subscript of the charactor in 
//      the source string.
//      For a given nRows, the hash function is:
//      j%(nRows+nRows-2)=i or base-i,
//      and to avoid collision, we store the same hash 
//      value charactors into a barrel.     
class Solution{
public:
	string convert(string s, int nRows){
	    if(nRows <= 1) return s;
		string res;
		int base = nRows+nRows-2;

		for(int i=0; i<nRows; i++){
			for(int j=0; j<s.size(); j++){
				if(j%base == i||j%base == base-i){
					res.insert(res.end(),s[j]);
				}
			}
		}

		return res;
	}
};
