package gestione;

public class Stack {
    private int[] mem;
    private int p, n;

    public Stack(int N) {
        mem = new int[N];
        p = 0;
        n = 0;
    }

    public void push(int x) {
        mem[p] = x;
        p++;
        n++;
    }
}