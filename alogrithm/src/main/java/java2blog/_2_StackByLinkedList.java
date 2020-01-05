package java2blog;

public class _2_StackByLinkedList {

    private Item head;

    private class Item {
        int value;
        Item next;

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public _2_StackByLinkedList() {
        this.head = head;
    }

    public void push(int element){
//        head.next.value = element;
        Item oldHead = this.head;
        head = new Item();
        head.value = element;
        head.next = oldHead;
    }

    public int pop(){
        if(head == null){
            throw new IllegalArgumentException("stack is empty");
        }
        Item oldHead = this.head;
        head = oldHead.next;
        return oldHead.value;
    }


    public static void main(String args[])
    {
        _2_StackByLinkedList lls=new _2_StackByLinkedList();
        lls.push(20);
        lls.push(50);
        lls.push(80);
        lls.push(40);
        lls.push(60);
        lls.push(75);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        System.out.println("Element removed from LinkedList: "+lls.pop());
        lls.push(10);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        System.out.println(lls.head.toString());
    }
}
