/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        if(intervals.size() == 0){
        	intervals.push_back(newInterval);
        	return intervals;
        }

        if(intervals[0].start>newInterval.end){
        	intervals.insert(intervals.begin(),newInterval);
        	return intervals;
        }

        if(intervals.back().end<newInterval.start){
        	intervals.push_back(newInterval);
        	return intervals;
        }

        int i = 0;
        for(i=0;i<intervals.size();i++){
        	if (intervals[i].start>=newInterval.start){
        	    break;	
        	}
        	if(intervals[i].end>=newInterval.start){
        		break;
        	}
        }

        newInterval.start = min(newInterval.start,intervals[i].start);

        int j = i;
        for(;j<intervals.size();j++){
        	if(intervals[j].start>newInterval.end){
        		j = j-1;
        		break;
        	}
        	if(intervals[j].end>=newInterval.end){
        		break;
        	}
        }

        if(j == intervals.size()){
        	j--;
        }

        newInterval.end = max(newInterval.end,intervals[j].end);

        std::vector<Interval> v;
        for(int k = 0; k<i; k++){
        	v.push_back(intervals[k]);
        }
        v.push_back(newInterval);
        for(int k = j+1;k<intervals.size();k++){
        	v.push_back(intervals[k]);
        }

        return v;
    }
};
