/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(arr) {
     let sum = arr.length*(arr.length+1)/2;
    let sum2 = 0;

    for(let i = 0 ;i <arr.length ;i ++){
        sum2 = sum2+arr[i];
    }

    return sum-sum2;
};