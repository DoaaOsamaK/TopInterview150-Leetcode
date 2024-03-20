class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode currNode = list1; // Start of the first list
        int index = 0; // Variable to track current position
        // Move to the element before index "a"
        while (index < a - 1) {
            currNode = currNode.next;
            index++;
        }
        ListNode front = currNode; // Store current position as "front"
        // Move to the element after index "b"
        while (index < b + 1) {
            currNode = currNode.next;
            index++;
        }
        ListNode rear = currNode; // Store current position as "rear"
        ListNode secondListTail = list2, secondListHead = list2;
        // Finding the tail of the second list
        while (secondListTail.next != null) {
            secondListTail = secondListTail.next;
        }
        // Link the front part of the second list after "front"
        front.next = secondListHead;
        // Link the rear part of the second list before "rear"
        secondListTail.next = rear;
        return list1; // Return the updated list
    }
}