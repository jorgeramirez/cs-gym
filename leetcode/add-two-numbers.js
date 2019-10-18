// Here I build the outcome as I perform the sum given that the
// list is reversed already.
// m size for l1
// n size for l2
// Time: O(max(m, n))
// Space: O(max(m, n))

// A follow up of this problem is if the list are not reversed. Well, a solution
// for this case would be to reversed the lists in the first place.
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
  let node1 = l1;
  let node2 = l2;
  let carry = 0;
  let output = new ListNode(0);
  let currentResNode = output;

  var a;
  var b;
  var tmp = 0;

  do {
    a = node1 === null ? 0 : node1.val;
    b = node2 === null ? 0 : node2.val;
    tmp = a + b + carry;
    carry = tmp >= 10 ? 1 : 0;
    tmp = tmp % 10;
    var newResNode = new ListNode(tmp);
    currentResNode.next = newResNode;
    currentResNode = newResNode;

    node1 = node1 !== null ? node1.next : null;
    node2 = node2 !== null ? node2.next : null;
  } while (node1 != null || node2 != null);

  if (carry) {
    currentResNode.next = new ListNode(carry);
  }
  return output.next;
};

function ListNode(val) {
  this.val = val;
  this.next = null;
}

function main() {
  var l11 = new ListNode(2);
  var l12 = new ListNode(4);
  var l13 = new ListNode(3);

  l11.next = l12;
  l12.next = l13;

  var l21 = new ListNode(5);
  var l22 = new ListNode(6);
  var l23 = new ListNode(4);

  l21.next = l22;
  l22.next = l23;

  console.log(addTwoNumbers(l11, l21));

  var x11 = new ListNode(5);
  var x21 = new ListNode(5);
  console.log(addTwoNumbers(x11, x21));
}

main();
