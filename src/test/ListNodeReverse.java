package test;


/**
 * 单向链表自旋
 */
public class ListNodeReverse {

    /**
     * 非递归的方法
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        if(null!=head){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
