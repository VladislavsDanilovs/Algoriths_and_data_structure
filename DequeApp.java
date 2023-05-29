package DequeAndSinglyCircList;

class DequeApp {
     DequeApp(int dequeSize) {
        this.deque = new Object[dequeSize];
        this.size = dequeSize;
        this.start = -1;
        this.end = 0;
    }

    public static void main(String[] args) {

        DequeApp deque = new DequeApp(3);

        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
        System.out.println(deque.size());
        System.out.println(deque.pushBack(3));
        System.out.println(deque.pushFront(2));
        System.out.println(deque.popFront());
        System.out.println(deque.isEmpty());
        deque.display();
        System.out.println(deque.popBack());
        deque.display();
        deque.clear();
        deque.display();
    }

        private final Object[] deque;
        private final int size;
        private int start;
        private int end;
        private int numberOfElements = 0;

        public boolean pushBack(int element) {
            if (!this.isFull()) {
                if (start == -1) {
                    start = 0;
                    end = 0;
                } else if (end == size - 1) {
                    end = 0;
                } else {
                    end++;
                }
                deque[end] = element;
                numberOfElements++;
                return true;
            }
            return false;
        }

        public boolean pushFront(int element) {
            if (!this.isFull()) {
                if (start == -1) {
                    start = 0;
                    end = 0;
                } else if (start == 0) {
                    start = size - 1;
                } else {
                    start--;
                }
                deque[start] = element;
                numberOfElements++;
                return true;
            }
            return false;
        }

        public boolean popBack() {
            if (!this.isEmpty()) {
                deque[end] = null;
                if (start == end) {
                    start = -1;
                    end = 0;
                } else if (end == 0) {
                    end = size - 1;
                } else {
                    end--;
                }
                numberOfElements--;
                return true;
            }
            return false;
        }

        public boolean popFront() {
            if (!this.isEmpty()) {
                deque[start] = null;
                if (start == end) {
                    start = -1;
                    end = 0;
                } else if (start == size - 1) {
                    start = -1;
                } else {
                    start++;
                }
                numberOfElements--;
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public boolean isFull() {
            return numberOfElements == size-1;
        }

        public void display() {
            if (!this.isEmpty()) {
                for (int i = 0; i < this.size; i++) {
                    System.out.println(deque[i]);
                }
            }
        }

        public void clear() {
            if (!this.isEmpty()) {
                for (int i = 0; i < this.size; i++) {
                    deque[i] = null;
                }
            }
        }

        public int size() {
            return this.size;
        }
}
