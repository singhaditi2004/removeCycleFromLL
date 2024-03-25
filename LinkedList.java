/**
 * LinkedList
 */
public class LinkedList {
    //initializing head of linkedlist
    private LinkedList.Node head;
    //creating linkedlist class
    public static class Node {
        private int data; // data variable can be of any other type as required 
        private Node next; // pointer to the next node
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //displaying linkedlist
    public void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.printf(curr.data + " ->" + " ");
            curr = curr.next;
        }
        System.out.printf("null");
    }
    // finding length of linkedlist 
    public int length(Node head){
        int length=0;
        if(head==null){
            return 0;
        }
        Node curr=head;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        return length;
    }
    // checking if linkedlist is empty or not 
    /*public boolean isEmpty(Node head){
        if(head==null){
            return true;
        }
        return false;
    }
    // inserting a new node at first position 
    public void insterATFirst(int val){
        Node temp=new Node(val);
        temp.next=head;
        head=temp;
    }
    //insert at given index assuming index is valid
    public void atIndex(int pos,int val){
        if(pos==1){
            insterATFirst(val); // because inserting at 1st position assuming one-based indexing will be the same case as of inserting at first position 
        }
        int counter = 1; // keeping track of current position
        Node curr = head;
        Node prev = null;
    
        while (curr != null && counter < pos) {
            counter++;
            prev = curr;
            curr = curr.next;
        }
    
        if (counter == pos) {
            Node temp = new Node(val);
            prev.next = temp;
            temp.next = curr;
        }
    }
    // inserting value at end of linklist
    public void insertAtLast(int val){
        if(isEmpty(head)){
            head.data=val;
            head.next=null;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        Node temp=new Node(val);
        curr.next=temp;
        temp.next=null;
    }
    // deleting first node 
    public int deleteAtFirst(){
        if(isEmpty(head)){ // if linkedlist is already empty we can not delete any element
            return 0;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        return temp.data;
        
    }
    // deleting at given index assuminhg index to be valid 
    public int deleteAtIndex(int pos){
        if(pos==1){
            deleteAtFirst(); // because deleting at 1st position assuming one-based indexing will be the same case as of deleting at first position 
        }
        int counter = 1; // keeping track of current position
        Node curr = head;
        Node prev = null;
    
        while (curr != null && counter < pos) {
            counter++;
            prev = curr;
            curr = curr.next;
        }
        int value=0;
        if (counter == pos) {
            Node temp = curr;
            value=temp.data;
            prev.next = curr.next;
            temp.next = null;
        }
        return value;
    }
    // deleting last node 
    public int deleteAtLast(){
        if(isEmpty(head)){ // if linkedlist is already empty we can not delete any element
            return 0;
        }
        Node curr=head;
        Node prev=null;
        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        
        Node temp=curr;
        prev.next=null;
        return temp.data;
    }
    // searching for a given element
    public int search(int val){ //this will return index at which elemnt is found or else -1 if not found
                                //performing linear search assuming linkedlist is not sorted
        Node curr=head;
        int index=1;
        while(curr!=null){
            if(curr.data==val){
                return index;
            }
            index++;
            curr=curr.next;
        }
        return -1;
    }

    //reversing the linkedlist 
    public Node reverseLinkedList(Node head){
        Node curr=head;
        Node prev=null;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
    */
    /*public  boolean hasCycle(Node head){
       Node slow = head;
       Node fast = head;
       while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            return true;
        }
       }
       return  false;
    }*/
    public Node findCycle(Node head){
       Node slow = head;
       Node fast = head;
       while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            removeLoop(slow);
        }
       }
      return slow;
    }

    public void removeLoop(Node slow){
        Node temp = head;
        while(slow.next!=temp.next){
            slow=slow.next;
            temp=temp.next;
        }
        slow.next=null;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(12);
        Node second = new Node(13);
        Node third = new Node(14);
        Node fourth = new Node(15);
        Node fifth = new Node(13);
        // connecting them
        list.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next=fifth;
        fifth.next=third;
        //list.isEmpty(list.head);
        //list.display(list.head);
        //System.out.println(list.length(list.head));
        // list.insterATFirst(0);
        //list.insertAtLast(0);
        //list.atIndex(3, 110);
        //list.deleteAtFirst();
        //list.deleteAtLast();
        //list.deleteAtIndex(2);
        //System.out.println(list.search(12));
       // list.display(list.head);
       // list.reverseLinkedList(list.head);
       // System.out.println(list.hasCycle(list.head));
        //list.display(list.reverseLinkedList(list.head));
    }

}