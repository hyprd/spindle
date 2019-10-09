#include <iostream>
#include <vector>
#include <queue>
#include <deque>
#include <list>
using namespace std;

class Coin{
    int value;
    public:
        Coin(int coinValue){
            value = coinValue;
        }
        int returnValue(){
            return value;
        }
};

queue<int> swapQueue;

void Swap(vector<Coin> c){
    Coin firstCoin = c[swapQueue.front()];
    Coin secondCoin = c[swapQueue.front() + 1];
    Coin handOff = c[swapQueue.front() + 1];
    secondCoin = firstCoin;
    firstCoin = handOff;
    c[swapQueue.front()] = firstCoin;
    c[swapQueue.front() + 1] = secondCoin;
    swapQueue.pop();
}

void Sweep(vector<Coin> c){
    for(int i = 0; i < c.size(); i++){
        if(!(c[i].returnValue() == c[i + 1].returnValue())){
            swapQueue.push(i);
            i++;
        }
    }
}

bool checkHeadsSequence(vector<Coin> c){
    cout << "checkHeadsSequence...";
    int breakPointHeads = 0;
    bool checkHeads = false;
    vector<int> headsSequence;
    for(int u = 0; u < c.size(); u++){
        headsSequence.push_back(c[u].returnValue());
        u++;
    }
    for(int y = 0; y < headsSequence.size(); y++){
        if(headsSequence[0] == headsSequence[y]){
            checkHeads = true;
        } else{
            breakPointHeads = y;
            return false;
        }
    }
    return checkHeads;
}

bool checkTailsSequence(vector<Coin> c){
    cout << "checkTailsSequence...";
    int breakPointTails = 0;
    bool checkTails = false;
    vector<int> tailsSequence;
    for(int u = 0; u < c.size(); u++){
        tailsSequence.push_back(c[u].returnValue());
        u++;
    }
    for(int y = 0; y < tailsSequence.size(); y++){
        if(tailsSequence[0] == tailsSequence[y]){
            checkTails = true;
        } else{
            breakPointTails = y;
            return false;
        }
    }
    return checkTails;
}

vector<Coin> Evaluate(vector<Coin> c){
    Sweep(c);
    bool isAlternating = false;
    while(!isAlternating){
        Swap(c);
        if(swapQueue.size() == 0){
            bool tailsCheck = checkTailsSequence(c);
            bool headsCheck = checkHeadsSequence(c);
            if(tailsCheck && headsCheck){
                isAlternating = true;
            } else{
                Sweep(c);
            }
        }
    }
    return c;
}

int main(){
    int count = 0;
    vector<int> totalMoveCountVector;
    vector<int> indexesVector;
    vector<Coin> coinVector;
    cout << "1 for input\n2 to print 2 < n < 20\n";
    int choice;
    cin >> choice;
    switch(choice){
        case 1:
            count = 0;
            coinVector.empty();
            cout << "Enter heads\n";
            int headsCount;
            cin >> headsCount;
            int tailsCount = headsCount;
            for(int k = 0; k < headsCount; k++){
                Coin c(1);
                coinVector.push_back(c);
            }
            for(int p = 0; p < tailsCount; p++){
                Coin c(0);
                coinVector.push_back(c);
            }
            Evaluate(coinVector);
            break;
    }
    return EXIT_SUCCESS;
}


