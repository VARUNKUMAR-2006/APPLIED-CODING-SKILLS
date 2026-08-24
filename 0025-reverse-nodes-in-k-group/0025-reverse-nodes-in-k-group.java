class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;

        // Check if there are at least k nodes
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect the reversed group to the next group
        head.next = reverseKGroup(current, k);

        return prev;
    }
}