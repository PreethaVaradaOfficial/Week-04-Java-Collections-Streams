public class CircularBuffer {
    int[] buffer;
    int size, start, end;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = 0;
        start = 0;
        end = 0;
    }

    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % buffer.length;
        if (size < buffer.length) size++;
        else start = (start + 1) % buffer.length;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(start + i) % buffer.length] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();  // Output: 1 2 3
        cb.insert(4);
        cb.display();  // Output: 2 3 4
    }
}