package easy;

public class DesignHashmap {
    static class MyHashmap {
        private static final double LOAD_FACTOR = 0.75;

        private int size = 0;

        private int cap = 16;

        Node[] table;


        public MyHashmap() {
            table = new Node[cap];
        }

        public void put(int key, int value) {
            int hash = hash(key);
            int index = hash & (cap - 1);
            Node cur = table[index];
            while (cur != null && cur.key != key) {
                cur = cur.next;
            }
            if (cur == null) {
                table[index] = new Node(key, value, hash, table[index]);
            } else {
                cur.value = value;
            }
            if (size > cap * LOAD_FACTOR) {
                resize();
            }
        }

        public int get(int key) {
            int index = hash(key) & (cap - 1);
            Node cur = table[index];
            while (cur != null && cur.key != key) {
                cur = cur.next;
            }
            return cur == null ? -1 : cur.value;
        }

        public void remove(int key) {
            int index = hash(key) & (cap - 1);
            Node cur = table[index];
            Node pre = null;
            while (cur != null && cur.key != key) {
                pre = cur;
                cur = cur.next;
            }
            if (cur != null) {
                size--;
                if (pre == null) {
                    table[index] = cur.next;
                } else {
                    pre.next = cur.next;
                }
            }
        }

        private int hash(int key) {
            int h = Integer.valueOf(key).hashCode();
            return h ^ (h >>> 16);
        }

        private void resize() {
            int oldCap = table.length;
            cap = oldCap * 2;
            Node[] newTable = new Node[cap];
            for (int i = 0; i < oldCap; i++) {
                Node lowerHead = new Node(-1, -1, -1, null);
                Node lowerTail = lowerHead;
                Node higherHead = new Node(-1, -1, -1, null);
                Node higherTail = new Node(-1, -1, -1, null);
                Node cur = table[i];
                while (cur != null) {
                    Node next = cur.next;
                    if ((cur.hash & oldCap) == 0) {
                        lowerTail.next = cur;
                        lowerTail = lowerTail.next;
                        lowerTail.next = null;
                    } else {
                        higherTail.next = cur;
                        higherTail = higherTail.next;
                        higherTail.next = null;
                    }
                    cur = next;
                }
                newTable[i] = lowerHead.next;
                newTable[i + oldCap] = higherHead.next;
            }
            table = newTable;
        }

        private static class Node {
            int key;
            int value;
            int hash;
            Node next;

            Node(int key, int value, int hash, Node next) {
                this.key = key;
                this.value = value;
                this.hash = hash;
                this.next = next;
            }
        }
    }
}
