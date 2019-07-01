public class LinkedList extends AbstractList implements List {
    /**
     * 结点类
     * 静态类
     */
    private static class Node {
        private int val;
        private Node next;

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        private Node(int val) {
            this(val, null);
        }
    }

    /**
     * 记录链表的第一个结点
     */
    private Node head = null;

    @Override
    protected void insertInternal(int index, int val) {
        if (index == 0) {
            head = new Node(val, head);
        } else {
            // 先去找 index 的前一个结点
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            // prev 就是 index 位置的前驱结点
            prev.next = new Node(val, prev.next);
        }
    }

    /**
     * 链表的迭代器类
     */
    private class LinkedListIterator implements Iterator {
        /**
         * 记录迭代器当前指向的结点
         */
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public int next() {
            int val = current.val;
            current = current.next;
            return val;
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
}
