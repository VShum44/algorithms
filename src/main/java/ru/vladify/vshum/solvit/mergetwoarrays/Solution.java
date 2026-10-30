package ru.vladify.vshum.solvit.mergetwoarrays;

/**
 * Определение односвязного списка.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Напишите здесь свой код
        if (list2 == null){ return list1; }
        if (list1 == null){ return list2; }

        ListNode begin;
        ListNode cur1;
        ListNode cur2;
        if(list1.val <= list2.val){
            begin = list1;
            cur1 = list1.next;
            cur2 = list2;
        }
        else {
            begin = list2;
            cur2 = list2.next;
            cur1 = list1;
        }
        ListNode tail = begin;

        while (cur1 != null || cur2 != null){

            if(cur1 != null && (cur2 == null || cur1.val <= cur2.val)){
                tail.next = cur1;
                tail = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                tail = cur2;
                cur2 = cur2.next;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3));
        ListNode list2 = new ListNode(2, new ListNode(4));

        ListNode result = new Solution().mergeTwoLists(list1, list2);

        System.out.println("Ожидается: [1, 2, 3, 4]");
        System.out.print("Получено:  [");

        ListNode current = result;
        int count = 0;

        // Ограничение вывода на случай, если в результате появился цикл.
        while (current != null && count < 10) {
            if (count > 0) {
                System.out.print(", ");
            }

            System.out.print(current.val);
            current = current.next;
            count++;
        }

        if (current != null) {
            System.out.print(", ... (возможен цикл)");
        }

        System.out.println("]");
    }
}

class ListNode {
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
}
