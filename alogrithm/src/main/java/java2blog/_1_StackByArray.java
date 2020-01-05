package java2blog;

public class _1_StackByArray {

    public int size;
    public int arr[];
    public int current;

    public _1_StackByArray(int size) {
        assert size >= 0;
        this.size = size;
        this.arr = new int[size];
        this.current = -1;
    }

    public void push(int element){
        if(isFull()){
            throw new IllegalArgumentException("stack is full");
        }
        current++;
        arr[current] = element;
        System.out.println(element);
    }

    private boolean isFull() {
        return current == size - 1;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("stack is empty");
        }
        int oldCurrent = current;
        current--;
        System.out.println(arr[oldCurrent]);
        return arr[oldCurrent];
    }

    private boolean isEmpty() {
        return current == -1;
    }

    public static void main(String[] args) {
        _1_StackByArray StackCustom = new _1_StackByArray(10);
//        StackCustom.pop();
        System.out.println("=================");
        StackCustom.push(10);
        StackCustom.push(30);
        StackCustom.push(50);
        StackCustom.push(40);
        System.out.println("=================");
        StackCustom.pop();
        StackCustom.pop();
        StackCustom.pop();
        System.out.println("=================");
    }
}
