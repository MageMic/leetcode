package interview;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: zjumic
 * @Date: created at 20:40 2020/4/18
 */
public class FeedAnimal {

    public abstract class Animal implements Comparable {
        int age;
        String name;
        abstract void feed();

        @Override
        public int compareTo(Object o) {
            Animal o2 = (Animal) o;
            return this.age - o2.age;
        }
    }

    public class Bear extends Animal {
        public Bear(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        void feed() {
            System.out.println("Feeding " + this.name + "a fish");
        }
    }

    public class Giraffe extends Animal {
        public Giraffe(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        void feed() {
            System.out.println("Feeding " + this.name + "leaves");
        }
    }

    public class Gorilla extends Animal {
        public Gorilla(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        void feed() {
            System.out.println("Feeding " + this.name + "a banana");
        }
    }

    public static void feed(ArrayList<Animal> animals) {
        PriorityQueue<Animal> pr = new PriorityQueue<>((a1, a2) -> a1.age - a2.age);
        for (Animal animal : animals) {
            pr.offer(animal);
            if (pr.size() > 10) {
                pr.poll();
            }
        }
        for (Animal animal : pr) {
            animal.feed();
        }
    }

    // 小顶堆
    public class Heap<T extends Comparable>{
        private ArrayList<T> data;
        public Heap(int capacity) {
            data = new ArrayList<T>(capacity);
        }
        public Heap() {
            data = new ArrayList<T>();
        }

        public int size() {
            return data.size();
        }

        private int parent(int index) {
            if (index == 0) {
                throw new IllegalArgumentException("index cannot be 0");

            }
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return index * 2 + 1;
        }

        private int rightChild(int index) {
            return index * 2 + 2;
        }

        public void offer(T t) {
            data.add(t);
            siftUp(data.size() - 1);
        }

        public T peek() {
            if (data.size() == 0) {
                return null;
            }
            return data.get(0);
        }

        public T poll() {
            T ret = peek();
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            siftDown(0);
            return ret;
        }

        private void siftUp(int k) {
            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
                swap(k, parent(k));
                k = parent(k);
            }
        }

        private void siftDown(int k) {
            while (leftChild(k) < data.size()) {
                int j = leftChild(k);

                if (j + 1 < data.size()) {
                    if (data.get(j + 1).compareTo(data.get(j)) < 0) {
                        j = rightChild(k);
                    }
                }

                if (data.get(k).compareTo(data.get(j)) <= 0) {
                    break;
                } else {
                    swap(k, j);
                }
                k = j;
            }
        }

        private void swap(int i, int j) {
            T temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }
    }
}
