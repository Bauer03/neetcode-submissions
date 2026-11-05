class LinkedList {
    private LinkNode head;
    private LinkNode tail;

    public LinkedList() {
        head = new LinkNode(-1);
        tail = head;
    }

    public int get(int index) {
        LinkNode ans = head.next; // because first node in list is -1 dummy, we use head.next instead of just head
        int i = 0;
        while(ans != null) {
            if(i == index) return ans.val;
            ans = ans.next;
            i++;
        }
        return -1; // not found
    }

    public void insertHead(int val) {
        LinkNode newNode = new LinkNode(val); // initialize a link to add to list
        newNode.next = head.next; // add whatever was in the list to the new one, since we're adding new one to head/start
        head.next = newNode; // now dummy node points to new node
        if(newNode.next == null) { // if list was empty, we now point tail to newnode
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        tail.next = new LinkNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        LinkNode cur = head.next;
        LinkNode prevNode = head; // dummy node comes in handy here, so that I can delete based on it
        while(cur != null) { // using while loop to catch ioob exception
            if(i == index) {
                prevNode.next = cur.next;
                if(tail == cur) { tail = prevNode; }
                return true;
            }
            i++;
            prevNode = cur;
            cur = cur.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        LinkNode cur = head.next;
        while(cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }
}

class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val) {
        this.val = val;
        next = null;
    }
    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}