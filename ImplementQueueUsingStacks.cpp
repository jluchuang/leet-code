/*************************************************************************
        > File Name: ImplementQueueUsingStacks.cpp
        > Author: jluchuang
        > Mail: jlu_chuang@163.com 
        > Created Time: 2015年08月15日 星期六 12时16分33秒
 ************************************************************************/

class Queue {
public:
    stack <int> stackHead; //The top of this stack is the front of the queue
    stack <int> stackTail;  //The top of this stack is the tail of the queue
    //Push element x to the back of queue
    void push(int x) {
        stackTail.push(x);
    }
    
    //Removes the element from in front of queue
    void pop(void) {
        if(stackHead.empty()) { 
            while(!stackTail.empty()) {
               stackHead.push(stackTail.top());
               stackTail.pop(); 
            }
        }
        if(!stackHead.empty()){
            stackHead.pop();
        }
    }
    
    //Get the front element
    int peek(void) {
        if(stackHead.empty()){
            while(!stackTail.empty()){
               stackHead.push(stackTail.top());
               stackTail.pop();
            }
        }
        return stackHead.top();
    }

    //Return whether the queue is empty
    bool empty(void) {
        if(stackHead.empty() && stackTail.empty()){
            return true;
        }
        return false;
    }
};
