package barig.adam.list;

import java.util.Collection;

public class CustomLinkedList<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public void add(T val) {
                Node<T> newNode = new Node<>(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: =" + index + ", Size: " + size);
            }

            Node<T> curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.data;
        }

        public int size() {
            return size;
        }

        public boolean contains(T val) {
            Node<T> curr = head;

            for (int i = 0; i < size; i++) {
                if (java.util.Objects.equals(curr.data, val)) {
                    return true;
                }
                else {
                    curr = curr.next;
                }
            }

            return false;
        }

        public void addAll(Collection<? extends T> vals) {
            for (T v : vals) {
                this.add(v);
            }
        }
}
