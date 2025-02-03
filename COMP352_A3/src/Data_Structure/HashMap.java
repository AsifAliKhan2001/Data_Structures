package Data_Structure;

import java.util.ArrayList;

public class HashMap<K,V> extends AbstractHashMap<K,V> {
    private MapEntry<K,V>[ ] table; // a fixed array of entries (all initially null)
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null); //sentinel

    public HashMap( ) { super( ); }
    public HashMap(int cap) { super(cap); }
    public HashMap(int cap, int p) { super(cap, p); }

    protected void createTable( ) {
        table = (MapEntry<K,V>[]) new MapEntry[capacity]; // safe cast
    }
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }
    private int findSlot(int h, K k) {
        int avail = -1; // no slot available (thus far)
        int j = h; // index while scanning table
        do {
            if (isAvailable(j)) { // may be either empty or defunct
                if (avail == -1) avail = j; // this is the first available slot!
                if (table[j] == null) break; // if empty, search fails immediately
            }
            else if (table[j].getKey( ).equals(k))
                return j; // successful match
            j = (j+1) % capacity; // keep looking (cyclically)
        } while (j != h); // stop if we return to the start
        return -(avail + 1); // search has failed
    }
    protected V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null; // no match found
        return table[j].getValue( );
    }
    protected V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if (j >= 0) // this key has an existing entry
            return table[j].setValue(v);
        table[-(j+1)] = new MapEntry<>(k, v); // convert to proper index
        n++;
        return null;
    }
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null; // nothing to remove
        V answer = table[j].getValue( );
        table[j] = DEFUNCT; // mark this slot as deactivated
        n--;
        return answer;
    }
    public Iterable<Entry<K,V>> entrySet( ) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>( );
        for (int h=0; h < capacity; h++)
            if (!isAvailable(h)) buffer.add(table[h]);
        return buffer;
    }

}
