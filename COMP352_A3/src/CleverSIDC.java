import java.util.Random;
import Data_Structure.HashMap;
import java.util.Arrays;

public class CleverSIDC {
    public static final int SMALLEST_ID = 10000000;
    public static final int BIGGEST_ID  = 99999999;
    int maxSize;	//max size
    private int size;	// current size
    HashMap<Integer,String> entries;
    private Integer[] keys;




    // constructor
    public CleverSIDC(int maxSize) {
        setSIDCThreshold(maxSize);
        entries = new HashMap<Integer, String>();
        keys = new Integer[maxSize + 1];
        size = 0;
    }

    // accessor methods
    public int getSize() {
        return this.size;
    }
    public Integer[] getKeys() {
        return this.keys;
    }



    // return the keys array time complexity O(1)
    public Integer[] allKeys(){
        return keys;
    }

    // to add an entry
    public void add(int key, String value){
        addKeyToArray(key);
        entries.put(key, value);
    }

    // to remove an entry
    public boolean remove(Integer key){
        if (removeKeyFromArray(key)){
            entries.remove(key);
            return true;
        }
        return false;
    }

    // to set the maximum size time and space complexity O(1)
    public void setSIDCThreshold(int maxSize) {
        this.maxSize=maxSize;
    }

    // get the value of the specific key O(1)
    public String getValue(Integer key){
        return (String) entries.get(key);
    }

    // O(n)
    private boolean removeKeyFromArray(Integer key){

        // linear search to find the index O(n)
        int i = 0;
        for(int k =0; k<size-1; k++){
            Integer j = keys[k];
            if(j.equals(key)){
                break;
            }
            i ++;
        } // we know the index

        if (i >=size) return false; // does not exist

        // shift the array left O(n)
        for(int k = i; k< keys.length-1; k++){
            keys[k] = keys[k+1];
        }
        size --;
        return true;
    }

    //O(n)
    private void addKeyToArray(Integer key){

        if(size == 0) {
            keys[0] = key;
            size ++;
        }
        // linear search to find right index so the key can be placed in the right place O(n)
        else {
            int i =0;
            for(int k =0; k<size; k++){
                Integer j = keys[k];
                if(j == null || key < j){
                    break;
                }
                i ++;
            }
            //to shift the values of the array  O(n)
            for(int k = keys.length-1; k>i; k-- ){
                keys[k] = keys[k-1];
            }
            //placing the key
            keys[i] = key;
        }
        size++;
    }

    private Integer binarySearch(Integer[] arr, Integer key){

        // for the add and remove we can do binary search instead of the linear search to find the index
        // if we don't change it it won't effect the overall complexity of the methods
        return 0;
    }


    // O(n)
    int generate() {
        Random rand = new Random(); //instance of random class
        boolean found_new = false;
        Integer int_random = rand.nextInt(BIGGEST_ID-SMALLEST_ID)+SMALLEST_ID;
        while (!found_new){ // o(N)

            found_new = (String) entries.get(int_random) == null; // O(1)
            if (! found_new) int_random++;
        }

        return int_random;
    }

    public int nextKey(int key) {
        if (size == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < size; i ++) {
            if (key == keys[i]) {
                index = i;
                break;
            }
        }
        return keys[index + 1];
    }

    public int prevKey(int key) {
        if (size == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < size; i ++) {
            if (key == keys[i]) {
                index = i;
                break;
            }
        }
        return keys[index - 1];
    }

    public int rangeKey(int key1, int key2) {
        if (size == 0) {
            return 0;
        }
        // find index of key 1
        int index1 = 0;
        for (int i = 0; i < keys.length; i ++) {
            if (key1 == keys[i]) {
                index1 = i;
                break;
            }
        }
        // find index of key 2
        int index2 = 0;
        for (int i = 0; i < keys.length; i ++) {
            if (key2 == keys[i]) {
                index2 = i;
                break;
            }
        }
        return index2 - index1 + 1;
    }
}
