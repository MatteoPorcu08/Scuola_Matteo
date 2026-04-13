package gestione;

public class Stack {
    private int[] mem;
    private int p, n;

    public Stack(int N) {
        mem = new int[N];
        p = 0;
        n = 0;
    }

    public boolean isFull () throws StackFullException {
        if (n == mem.length) {
            throw new StackFullException();
        }
        return false;
    }

    public boolean isEmpty () throws StackEmptyException {
        if (n == 0) {
            throw new StackEmptyException();
        }
        return false;
    }

    public void push(int x) throws StackFullException {
        if(!isFull()) {
            mem[p] = x;
            p++;
            n++;
        }
    }


    public void pop() throws StackEmptyException {
        if(!isEmpty()) {
            p--;
            n--;
        }
    }
}