package interview;

import java.util.HashMap;

/**
 * @Author: zjumic
 * @Date: created at 16:32 2020/3/12
 */
public class LRUCache<K, V> {

    private HashMap<K, Node<V>> keyNodeMap;
    private HashMap<Node<V>, K> nodeKeyMap;
    private NodeDoubleLinkedList<V> nodeList;
    private int capacity;

    public LRUCache(int capacity){
        if (capacity < 1) {
            throw new IllegalArgumentException("should be more than 1");
        }
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeDoubleLinkedList<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        if (keyNodeMap.containsKey(key)) {
            Node<V> res = keyNodeMap.get(key);
            nodeList.moveNodeToTail(res);
            return res.value;
        }
        return null;
    }

    public void set(K key, V value) {
        if (this.keyNodeMap.containsKey(key)) {
            Node<V> node = keyNodeMap.get(key);
            node.value = value;
            nodeList.moveNodeToTail(node);
        } else {
            Node<V> node = new Node<>(value);
            keyNodeMap.put(key, node);
            nodeKeyMap.put(node, key);
            nodeList.addNode(node);
            if (keyNodeMap.size() == capacity + 1) {
                removeLRUNode();
            }
        }
    }

    private void removeLRUNode() {
        Node<V> removeNode = nodeList.removeHead();
        K key = nodeKeyMap.get(removeNode);

        nodeKeyMap.remove(removeNode);
        keyNodeMap.remove(key);
    }

    private class Node<V> {
        V value;
        Node<V> last;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }

    private class NodeDoubleLinkedList<V> {

        Node<V> head;
        Node<V> tail;

        NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        void addNode(Node<V> newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }

        void moveNodeToTail(Node<V> node) {
            if (tail == node) {
                return;
            }
            if (head == node) {
                head = head.next;
                head.last = null;
            } else {
                 node.last.next = node.next;
                 node.next.last = node.last;
            }

            node.next = null;
            node.last = tail;
            tail.next = node;
            tail = node;
        }

        Node<V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<V> res = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                res.next = null;
            }
            return res;
        }
    }
}
