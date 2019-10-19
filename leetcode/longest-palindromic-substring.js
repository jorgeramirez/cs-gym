// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.

// Example 2:
// Input: "cbbd"
// Output: "bb"

var isPalindrome = function(s, i, j) {
  var k = i;
  var m = j;

  while (k !== m && k < m) {
    if (s[k] !== s[m]) {
      return false;
    }
    ++k;
    --m;
  }
  return true;
};

// Brute force
// Time: O(n^3)
// Space: O(1)

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  let windowSize = 0;
  let longest = [];

  for (let i = 0; i < s.length; i++) {
    let j = i + windowSize;

    if (j >= s.length) {
      break;
    }

    while (j < s.length) {
      if (isPalindrome(s, i, j)) {
        windowSize = j - i + 1;
        longest = [i, j];
      }
      ++j;
    }
  }
  return s.slice(longest[0], longest[1] + 1);
};

// DP solution
// Time: O(n^2)
// Space: O(n^2)
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  // update rules
  // P[i, i] = 1
  // P[i, i+1] = 1
  // P[i, j] = P[i+1, j-1] + 2 if s[i] == s[j]
  // P[i, j] = max(P[i, j-1], P[i+1, j]) if s[i] != s[j]

  if (s.length === 0 || s.length === 1) {
    return s;
  }

  let P = [];

  for (let i = 0; i < s.length; i++) {
    P[i] = [];
    for (let j = 0; j < s.length; j++) {
      P[i][j] = undefined;
    }
  }

  for (let i = 0; i < s.length; i++) {
    P[i][i] = 1;
  }

  let longest = 1;
  let longestRange = [0, 0];

  for (let w = 1; w < s.length; w++) {
    for (let i = 0; i < s.length - w; i++) {
      let j = i + w;

      if (s[i] === s[j] && w == 1) {
        P[i][j] = 2;
      } else if (s[i] === s[j] && w > 1) {
        P[i][j] = P[i + 1][j - 1] + 2;
      } else if (s[i] !== s[j] && w > 1) {
        P[i][j] = Math.max(P[i][j - 1], P[i + 1][j]);
      }

      if (P[i][j] > longest) {
        longest = P[i][j];
        longestRange = [i, j];
      }
    }
  }

  return s.slice(longestRange[0], longestRange[1] + 1);
};

console.log('aba', longestPalindrome('aba'));
console.log('babad', longestPalindrome('babad'));
console.log('cbbd', longestPalindrome('cbbd'));
console.log('a', longestPalindrome('a'));
console.log('ac', longestPalindrome('ac'));
console.log('aaaa', longestPalindrome('aaaa'));
console.log('abcba', longestPalindrome('abcba'));
console.log('babadada', longestPalindrome('babadada'));

console.log(
  'kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv',
  longestPalindrome(
    'kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv'
  )
);

console.log(
  'dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd',
  longestPalindrome(
    'dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd'
  )
);

module.exports = { longestPalindrome };
