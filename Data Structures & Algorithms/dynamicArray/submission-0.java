class DynamicArray {
    private int[] arr;
    private int length; // not a property of arr, but instead a counter for the number of elements in the array
    private int capacity;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        length = 0; // length is, for some reason, being used as a proxy for populated elements?
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) { // i'd honestly use an arraylist and just push.
        if(length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0) length --;
        return arr[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for(int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
