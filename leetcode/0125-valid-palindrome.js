/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
  s = s.toLowerCase().replace(/\W/g, '');
  var k = 0;
  var m = s.length - 1;

  while (k !== m && k < m) {
    console.log(s[k], s[m]);
    if (s[k] !== s[m]) {
      return false;
    }
    ++k;
    --m;
  }
  return true;
};
