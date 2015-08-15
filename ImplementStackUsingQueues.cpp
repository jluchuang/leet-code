/*************************************************************************
        > File Name: ImplementStackUsingQueues.cpp
        > Author: jluchuang
        > Mail: jlu_chuang@163.com 
        > Created Time: 2015年08月15日 星期六 12时43分33秒
 ************************************************************************/

class Stack {
public:
    queue <int> queue1;
    queue <int> queue2;
    //Push element x into stack
    void push(int x) {
        if(!queue1.empty()){
            queue1.push(x); 
        } 
        else {
            queue2.push(x); 
        }
    }
    
    //Removes the element on top of the stack
    void pop() {
        queue<int> * pQ1 = NULL;   // the queue having element
        queue<int> * pQ2 = NULL;   // the queue empty
        if(!queue1.empty()){
             pQ1 = &queue1;
             pQ2 = &queue2;
        }
        else{
             pQ1 = &queue2;
             pQ2 = &queue1;
        }
        
        while(!pQ1->empty() && pQ1->size() != 1){
            pQ2->push(pQ1->front());
            pQ1->pop();
        }
        if(!pQ1->empty()){
            pQ1->pop();
        }
    } 
   
    //Get the top element
    int top() { 
        queue<int> * pQ1 = NULL;   // the queue having element
        queue<int> * pQ2 = NULL;   // the queue empty
        if(!queue1.empty()){
             pQ1 = &queue1;
             pQ2 = &queue2;
        }
        else{
             pQ1 = &queue2;
             pQ2 = &queue1;
        }
        
        while(!pQ1->empty() && pQ1->size() != 1){
            pQ2->push(pQ1->front());
            pQ1->pop();
        }
        int res = pQ1->front();
        pQ2->push(pQ1->front());
        pQ1->pop();
        return res;
    } 
  
    //Return the stack is empty
    bool empty() { 
        return (queue1.empty() && queue2.empty());
    }
}; 

