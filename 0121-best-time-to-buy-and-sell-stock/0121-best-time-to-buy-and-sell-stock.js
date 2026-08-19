/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    
    let maxProfit = 0;
    let minVal = prices[0];

    for(let i = 1 ;i <prices.length ; i++){
        if(prices[i]<minVal){
            minVal = prices[i];
        }

        let currentProfit = prices[i]-minVal;
        if(currentProfit>maxProfit){
            maxProfit = currentProfit
        }
    }

    return maxProfit;
};