var isPalindrome = function(s) {
  s = s.toLowerCase().replace(/\W/g, '');
  var k = 0;
  var m = s.length - 1;

  while (k !== m && k < m) {
    if (s[k] !== s[m]) {
      return false;
    }
    ++k;
    --m;
  }
  return true;
};

console.log('race a car', isPalindrome('race a car'));
console.log(
  'A man, a plan, a canal: Panama',
  isPalindrome('A man, a plan, a canal: Panama')
);
console.log('', isPalindrome(''));
console.log('ab@a', isPalindrome('ab@a'));
console.log('bb', isPalindrome('bb'));
