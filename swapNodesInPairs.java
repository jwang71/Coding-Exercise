    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);   
        ListNode pre = dummy;
        ListNode cur = head;    
        
        while (cur != null && cur.next != null) {
            ListNode nextNext = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = nextNext;
            pre = cur;        
            cur = nextNext;
        }
        
        return dummy.next;
    }

    //Recursion
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode next = head.next;
        ListNode temp = swapPairs(next.next);
        head.next = temp;
        next.next = head;
        return next;
    }