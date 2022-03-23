package AddTwoNumbers;

class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
    }
}

class LinkedList {
    ListNode head;

    public ListNode generateLinkedList(int[] arr) throws NullPointerException {
        if (arr.length == 0) {
            throw new NullPointerException("Array is Empty");
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode();
            node.val = arr[i];
            node.next = this.head;
            this.head = node;
        }
        return this.head;
    }

}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr_ptr = new ListNode();
        ListNode head = curr_ptr;
        int carry = 0;
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        while (l1_ptr.next != null && l2_ptr.next != null) {
            curr_ptr.next = new ListNode();
            if (l1_ptr.val + l2_ptr.val + carry > 9) {
                curr_ptr.val = (l1_ptr.val + l2_ptr.val + carry) - 10;
                carry = 1;
            } else {
                curr_ptr.val = l1_ptr.val + l2_ptr.val + carry;
                carry = 0;
            }
            curr_ptr = curr_ptr.next;
            l1_ptr = l1_ptr.next;
            l2_ptr = l2_ptr.next;
        }

        if (l1_ptr.val + l2_ptr.val + carry > 9) {
            curr_ptr.val = (l1_ptr.val + l2_ptr.val + carry) - 10;
            carry = 1;
        } else {
            curr_ptr.val = l1_ptr.val + l2_ptr.val + carry;
            carry = 0;
        }
        l1_ptr = l1_ptr.next;
        l2_ptr = l2_ptr.next;


        return head;
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {4, 6, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head1 = linkedList.generateLinkedList(arr1);
        ListNode head2 = linkedList.generateLinkedList(arr2);

    }
}
