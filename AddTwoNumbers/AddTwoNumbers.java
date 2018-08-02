package AddTwoNumbers;

//2. Add Two Numbers
//    Average Rating: 4.65 (390 votes)
//
//    April 5, 2016  |  288.2K views
//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Example:
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.
class addTwoNumbers {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head;
    ListNode cursor;
    int l1Count = 0;
    int l2Count = 0;
    ListNode l1Cursor = l1;
    ListNode l2Cursor = l2;
    int step = 0;
    while (l1Cursor != null) {
      l1Count++;
      l1Cursor = l1Cursor.next;
    }
    while (l2Cursor != null) {
      l2Count++;
      l2Cursor = l2Cursor.next;
    }
    if (l1Count == l2Count) {
      if ((l1.val + l2.val) / 10 > 0) {
        step = 1;
      }
      head = new ListNode((l1.val + l2.val) % 10);
      cursor = head;
      l1 = l1.next;
      l2 = l2.next;
      while (l1 != null) {
        cursor.next = new ListNode((l1.val + l2.val + step) % 10 );
        if ((l1.val + l2.val + step) / 10 > 0) {
          step = 1;
        } else {
          step = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        cursor = cursor.next;
      }
    } else if (l1Count > l2Count) {
      if ((l1.val + l2.val) / 10 > 0) {
        step = 1;
      }
      head = new ListNode((l1.val+l2.val)%10);
      cursor = head;
      l1 = l1.next;
      l2 = l2.next;
      l2Count--;
      while (l2Count != 0) {
        cursor.next = new ListNode((l1.val + l2.val + step) % 10);
        if ((l1.val + l2.val + step) / 10 > 0) {
          step = 1;
        } else {
          step = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        cursor = cursor.next;
        l2Count--;
      }
      while (l1 != null) {
        cursor.next = new ListNode((l1.val+step)%10);
        if ((l1.val + step) / 10 > 0) {
          step = 1;
        } else {
          step = 0;
        }
        cursor = cursor.next;
        l1 = l1.next;
      }
    } else {
      if ((l1.val + l2.val) / 10 > 0) {
        step = 1;
      }
      head = new ListNode((l1.val+l2.val)%10);
      cursor = head;
      l1 = l1.next;
      l2 = l2.next;
      l1Count--;
      while (l1Count != 0) {
        cursor.next = new ListNode((l1.val + l2.val + step) % 10);
        if ((l1.val + l2.val + step) / 10 > 0) {
          step = 1;
        } else {
          step = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        cursor = cursor.next;
        l1Count--;
      }
      while (l2 != null) {
        cursor.next = new ListNode((l2.val + step)%10);
        if ((l2.val + step)/ 10 > 0) {
          step = 1;
        } else {
          step = 0;
        }
        cursor = cursor.next;
        l2 = l2.next;
      }
    }
    if (step == 1) {
      cursor.next = new ListNode(step);
      cursor = cursor.next;
    }
    return head;
  }

  public static void main(String[] args) {
//        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2);
//        AddTwoNumbers.ListNode l1Cursor = l1;
//        l1Cursor.next = new AddTwoNumbers.ListNode(4);
//        l1Cursor = l1Cursor.next;
//        l1Cursor.next = new AddTwoNumbers.ListNode(3);
//        l1Cursor = l1Cursor.next;
//
//        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5);
//        AddTwoNumbers.ListNode l2Cursor = l2;
//        l2Cursor.next = new AddTwoNumbers.ListNode(6);
//        l2Cursor = l2Cursor.next;
//        l2Cursor.next = new AddTwoNumbers.ListNode(4);
//        l2Cursor = l2Cursor.next;

    ListNode l1 = new ListNode(3);
    ListNode l1Cursor = l1;
    l1Cursor.next = new ListNode(7);
    l1Cursor = l1Cursor.next;

    ListNode l2 = new ListNode(9);
    ListNode l2Cursor = l2;
    l2Cursor.next = new ListNode(2);
    l2Cursor = l2Cursor.next;

    ListNode head = addTwoNumbers(l1, l2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

}