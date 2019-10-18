const {
  lengthOfLongestSubstring
} = require('./longest-substring-without-repeating-characters');

test('abcabcbb => 3', () => {
  expect(lengthOfLongestSubstring('abcabcbb')).toBe(3);
});


test('bbbbb => 1', () => {
  expect(lengthOfLongestSubstring('bbbbb')).toBe(1);
});


test('pwwkew => 3', () => {
  expect(lengthOfLongestSubstring('pwwkew')).toBe(3);
});

test('" " => 1', () => {
  expect(lengthOfLongestSubstring(' ')).toBe(1);
});


test('dvdf => 3', () => {
  expect(lengthOfLongestSubstring('dvdf')).toBe(3);
});

test('zzzzzzabcd => 5', () => {
  expect(lengthOfLongestSubstring('zzzzzzabcd')).toBe(5);
});