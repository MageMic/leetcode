package linkedlist;

import java.util.HashMap;

// 146. LRU缓存机制
public class LRU<K, V> {

    private HashMap<K, Node<V>> keyNodeMap;
    private HashMap<Node<V>, K> nodeKeyMap;
    private NodeDoubleLinkedList<V> nodeList;
    private int capacity;

    public LRU(int capacity) {
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeDoubleLinkedList<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        if (keyNodeMap.containsKey(key)) {
            V res = keyNodeMap.get(key).value;
            nodeList.moveNodeToTail(keyNodeMap.get(key));
            return res;
        } else {
            return null;
        }
    }

    public void set(K key, V value) {
        if (keyNodeMap.containsKey(key)) {
            Node<V> node = keyNodeMap.get(key);
            node.value = value;
            nodeList.moveNodeToTail(node);
        } else {
            Node<V> node = new Node<>(value);
            keyNodeMap.put(key, node);
            nodeKeyMap.put(node, key);
            nodeList.addNode(node);
            // 是否超过了容量，如果超过，要移除
            if (keyNodeMap.size() == capacity + 1) {
                removeLRUNode();
            }
        }
    }

    private void removeLRUNode() {
        Node<V> head = nodeList.removeHead();
        K key = nodeKeyMap.get(head);

        keyNodeMap.remove(key);
        nodeKeyMap.remove(head);
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
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }

        void moveNodeToTail(Node<V> node) {
            if (node == null) {
                return;
            }
            if (head == node) {
                head = head.next;
                head.last = null;
            } else {
                Node<V> next = node.next;
                Node<V> last = node.last;
                last.next = next;
                next.last = last;
            }
            node.next = null;
            tail.next = node;
            node.last = tail;
            tail = node;
        }

        Node<V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<V> ret = head;
            // 如果head和tail是同一节点？
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                ret.next = null;
            }
            return ret;
        }
    }
}
