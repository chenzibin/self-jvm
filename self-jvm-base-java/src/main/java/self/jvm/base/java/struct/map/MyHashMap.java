package self.jvm.base.java.struct.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * MyHashMap
 *
 * @author chenzb
 * @date 2020/3/24
 */
public class MyHashMap<K,V> implements Map<K,V> {

    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 延迟到需要的时候初始化，在构造函数中不进行初始化
     */
    private Node<K,V>[] table;

    /**
     * The number of key-value mappings contained in this map
     */
    private int size;

    /**
     * 加载因子, 每次扩容的比例大小
     */
    private final float loadFactor;

    /**
     * 阈值，下次扩容后的大小
     */
    private int threshold;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (table == null) {
            table = new Node[threshold];
        }

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
