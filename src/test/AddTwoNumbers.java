package test;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		boolean adding = true;
		ListNode result = new ListNode();
		ListNode next = result;

		int carry = 0;

		while (adding) {
			int addend = 0, addmend = 0;
			adding = false;

			if (l1 != null) {
				addend = l1.val;
			}

			if (l2 != null) {
				addmend = l2.val;
			}

			next.val = (addend + addmend + carry) % 10;
			carry = (addend + addmend + carry) / 10;

			if (l1 != null && l1.next != null) {
				adding = true;
				l1 = l1.next;
			} else {
				l1 = null;
			}
			if (l2 != null && l2.next != null) {
				adding = true;
				l2 = l2.next;
			} else {
				l2 = null;
			}

			if (adding) {
				next.next = new ListNode();
				next = next.next;
			} else if (carry != 0) {
				next.next = new ListNode(carry);
			}
		}
		next = null;
		return result;
	}

}
