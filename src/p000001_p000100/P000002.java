package p000001_p000100;

public class P000002 {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode);
	}
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return getTwoNumbers(l1, l2, 0);
	}

	private static ListNode getTwoNumbers(ListNode l1, ListNode l2, int carry){
		if (l1 == null && l2 == null) {
			if (carry == 1) {
				return new ListNode(1);
			}
			return null;
		}

		int left = 0;
		ListNode leftPtr = null;
		if (l1 != null) {
			left = l1.val;
			leftPtr = l1.next;
		}

		int right = 0;
		ListNode rightPtr = null;
		if (l2 != null) {
			right = l2.val;
			rightPtr = l2.next;
		}

		int tempResult = left + right + carry;
		return new ListNode(tempResult % 10, getTwoNumbers(leftPtr, rightPtr, tempResult / 10));
	}
}
