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
