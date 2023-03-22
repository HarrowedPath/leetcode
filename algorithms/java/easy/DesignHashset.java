package easy;

import java.util.ArrayList;
import java.util.List;

public class DesignHashset {
    static class MyHashSet {
        List<List<Integer>> set;

        private static final double LOAD_FACTOR = 0.75;

        private int bucketSize;

        private int size;


        public MyHashSet() {
            bucketSize = 16;
            size = 0;
            set = new ArrayList<>();
            for (int i = 0; i < bucketSize; i++) {
                set.add(null);
            }
        }

        public void add(int key) {
            double load = loadFactor();
            if (load > LOAD_FACTOR) {
                rehash();
            }

            int bucket = hashFunction(key);
            List<Integer> list = set.get(bucket);
            if (list == null) {
                list = new ArrayList<>();
                set.set(bucket, list);
            }
            for (Integer integer : list) {
                if (integer == key) {
                    return;
                }
            }
            size++;
            list.add(key);
        }

        private void rehash() {
            List<List<Integer>> temp = set;
            set = new ArrayList<>();
            bucketSize *= 1.5;
            for (int i = 0; i < bucketSize; i++) {
                set.add(null);
            }
            size = 0;
            for (List<Integer> list : temp) {
                if (list != null) {
                    for (int e : list) {
                        add(e);
                    }
                }
            }
        }

        private int hashFunction(int key) {
            return key % bucketSize;
        }


        private double loadFactor() {
            return 1.0 * size / bucketSize;
        }

        public void remove(int key) {
            int bucket = hashFunction(key);
            List<Integer> list = set.get(bucket);
            if (list == null) {
                return;
            }

            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return;
            }

            int lastIndex = list.size() - 1;
            list.set(index, list.get(lastIndex));
            list.remove(lastIndex);
            size--;
        }

        public boolean contains(int key) {
            int index = hashFunction(key);
            List<Integer> list = set.get(index);
            if (list == null) {
                return false;
            }

            for (Integer integer : list) {
                if (integer == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
