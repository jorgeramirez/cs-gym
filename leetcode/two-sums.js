// brute force Time O(n^2) Space O(1)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        return [i, j];
      }
    }
  }
};

// hashtable to store the complements. We return when we find the first pair of numbers
// that sums up to target. Time O(n)  Space O(n).

var twoSum = function(nums, target) {
  let complements = new Map();

  for (let i = 0; i < nums.length; i++) {
    if (complements.has(nums[i])) {
      return [complements.get(nums[i]), i];
    }
    complements.set(target - nums[i], i);
  }
};
