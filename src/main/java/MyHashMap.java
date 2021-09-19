/**
 * @author coolestyue
 * 要努力呀.
 */
public class MyHashMap <K, V>{
    Entry[] entrys;
    int capacity;
    int size;
    public MyHashMap(int size){
        this.size = size;
        int capacity = 16;
        while (capacity < size) {
            capacity <<= 1;
        }
        entrys = new Entry[capacity];
    }
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash & (capacity - 1);
        if (entrys[index] == null) {
            entrys[index] = new Entry<K, V>(hash, key, value, null);
            size ++;
        } else {
            Entry cur = entrys[index];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            entrys[index] = new Entry<K, V>(hash, key, value, entrys[index]);
            size ++;
        }
    }
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash & (capacity - 1);
        if (entrys[index] == null) return null;
        Entry cur = entrys[index];
        while (cur != null) {
            if (cur.key == key) {
                return (V) cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
    private static class Entry<K, V> {
        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        int hash;
        K key;
        V value;
        Entry<K, V> next;

    }
}
