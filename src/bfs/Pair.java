package bfs;

/**
 * @Author: zjumic
 * @Date: created at 23:55 2020/3/21
 */
public class Pair<T> {
    private T key;
    private T value;
    Pair(T key, T value) {
        this.key = key;
        this.value = value;
    }
    public T getKey() {
        return key;
    }
    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() >>> 16 + value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair o = (Pair) obj;
        return this.key == o.getKey() && this.value == o.getValue();
    }
}
