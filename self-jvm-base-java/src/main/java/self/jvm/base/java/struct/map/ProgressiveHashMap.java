package self.jvm.base.java.struct.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * ProgressiveHashMap
 * 1、自动扩容
 * 2、Hash算法，均衡分布、减少碰撞
 * 3、Hash冲突，拉链法，头插尾插
 * 4、Rehash, 自动扩容时， 通过rehash映射到新的数组中
 * 5、渐进式rehash，防止大数据量时，扩容rehash导致系统暂时不可用
 *
 * @author chenzb
 * @date 2021/4/8
 */
public class ProgressiveHashMap<K, V> implements Map<K, V> {

    private final float loaderFactor = 0.75f;

    private Node<K, V>[] table;

    /**
     * 包含的键值对数，用于查询时时间复杂度O(1)
     */
    private int size;

    /**
     * 当前分配的数组大小
     */
    private int threshold;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (size == 0) {
            return false;
        }
        int hashCode = key.hashCode();
        int perturbHashCode = hashCode ^ (hashCode >>> 16);
        int index = perturbHashCode & (threshold - 1);

        for (Node node = table[index]; node != null; node = node.next) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (size == 0) {
            return false;
        }

        for (Node node : table) {
            Node curNode = node;
            while (curNode != null) {
                if (node.getValue() == value || node.getValue().equals(value)) {
                    return true;
                }
                curNode = node.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public class Node<K,V> implements Entry<K,V> {

        private Node<K, V> next;

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}
