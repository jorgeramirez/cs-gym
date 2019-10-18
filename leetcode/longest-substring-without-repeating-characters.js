// Time complexity: O(2n) = O(n)
// Space complexity: O(n)

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
  let charsMap = new Map();
  let idx = 0;
  let currentLength = 0;
  let maxLength = 0;
  const N = s.length;

  while (idx < N) {
    if (!charsMap.has(s[idx])) {
      charsMap.set(s[idx], idx);
      ++currentLength;
    } else {
      // duplicated char, we take the max of the current unique substring and what we have so far
      maxLength = currentLength > maxLength ? currentLength : maxLength;
      // we rewind the index to the position of this char and the ++idx line will move to the next character.
      idx = charsMap.get(s[idx]);
      charsMap.clear();
      currentLength = 0;
    }
    ++idx;
  }

  if (currentLength > maxLength) {
    maxLength = currentLength;
  }
  return maxLength;
};

module.exports = { lengthOfLongestSubstring };
