import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CleverSIDC_Driver {
    public static void main(String[] args) {
        Scanner s;

        // ----------------------------- SET 1 ------------------------------------
        /**
        try {
	    s = new Scanner(new FileInputStream("/Users/Asif/Desktop/COMP352_A3/COMP352_A3/src/NASTA_test_file1.txt"));
            CleverSIDC cleverSIDC = new CleverSIDC(500001);
            test(s, cleverSIDC);
            System.out.println("\nDONE TESTING FOR NASTA_test_file1.txt\n");
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //TYPE 2
		*/
		try {
			s = new Scanner(new FileInputStream("/Users/Asif/Desktop/COMP352_A3/COMP352_A3/src/NASTA_test_file2.txt"));
			CleverSIDC cleverSIDC = new CleverSIDC(500001);
			test(s, cleverSIDC);
			System.out.println("\nDONE TESTING FOR NASTA_test_file2.txt\n");
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


        //TYPE 3
		/*
		try {
			s = new Scanner(new FileInputStream("/Users/Asif/Desktop/COMP352_A3/COMP352_A3/src/NASTA_test_file3.txt"));
			CleverSIDC cleverSIDC = new CleverSIDC(500001);
			test(s, cleverSIDC);
			System.out.println("\nDONE TESTING FOR NASTA_test_file3.txt\n");
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} */


        //TYPE 4
		/*
		CleverSIDC cleverSIDC = new CleverSIDC(10);
		Integer[] generatedSet1 = new Integer[cleverSIDC.maxEntries];
		for (int i = 0; i < generatedSet1.length; i++) {
			generatedSet1[i] = cleverSIDC.generate();
		}
		System.out.println("\nTESTING FOR generatedSet4\n");
		testGenerated(cleverSIDC, generatedSet1);
		System.out.println("\nDONE TESTING FOR generatedSet4\n");
		*/

        //TYPE 5
		/*
		CleverSIDC cleverSIDC = new CleverSIDC (20);
		Integer[] generatedSet2 = new Integer[cleverSIDC.maxEntries];
		for (int i = 0; i < generatedSet2.length; i++) {
			generatedSet2[i] = cleverSIDC.generate();
		}
		System.out.println("\nTESTING FOR generatedSet5\n");
		testGenerated(cleverSIDC, generatedSet2);
		System.out.println("\nDONE TESTING FOR generatedSet5\n");
		*/
    }

    public static void test(Scanner s, CleverSIDC cleverSIDC) {
        int i = 1;
        int count = 0;
        // use given dataset of keys for the CleverSIDC
        // System.out.println("Adding given dataset to our CleverSIDC object...\n");
        while (count < 1500) {
            cleverSIDC.add(s.nextInt(), "Test Value " + i);
            i++;
            count++;
        }
        System.out.println("\nDone adding the dataset to our cleverSIDC!");

        // testing allKeys() method
        System.out.println("\nTESTING allKeys() method:\n");
        Integer[] allkeys = cleverSIDC.allKeys();
        for (int j = 0; j < cleverSIDC.getSize() -1; j++) {
            if (allkeys[j] != null) {
                System.out.println(String.format("%08d",allkeys[j]));
            }
        }
        System.out.println("\nDone testing allKeys()!\n");


        // testing getValues(), nextKey(), prevKey() methods
        System.out.println("\nTESTING getValue(), nextKey(), and prevKey() methods:\n");

        int testkey = cleverSIDC.getKeys()[1000];
        String sTestkey = String.format("%08d",testkey);
        System.out.println("Now calling getValue() for " + sTestkey + ":");
        String value = cleverSIDC.getValue(testkey);
        System.out.println("Getting the value for key " + sTestkey + ": '" + value + "'\n");

        System.out.println("Now calling getValue() for nextKey(" + sTestkey + "):");
        int testkey2 = cleverSIDC.nextKey(testkey);
        String sTestkey2 = String.format("%08d",testkey2);
        String value2 = cleverSIDC.getValue(testkey2);
        System.out.println("Getting the value for key " + sTestkey2 + ": '" + value2 + "'\n");

        System.out.println("Now calling getValue() for prevKey(" + sTestkey + "):");
        int testkey3 = cleverSIDC.prevKey(testkey);
        String sTestkey3 = String.format("%08d",testkey3);
        String value3 = cleverSIDC.getValue(testkey3);
        System.out.println("Getting the value for key " + sTestkey3 + ": '" + value3 + "'\n");


        // testing add method
        System.out.println("\nTESTING add method:\n");
        int generatedkey = cleverSIDC.generate();
        String valueGK = "Value for generated key!";
        System.out.println("Adding entry: K = " + String.format("%08d",generatedkey)
                + ", V = " + "'" + valueGK + "'\n");
        cleverSIDC.add(generatedkey, valueGK);

        // testing remove method
        System.out.println("\nTESTING remove method:\n");
        int toRemove = cleverSIDC.getKeys()[1000];
        System.out.println("Removing entry for K = " + String.format("%08d",toRemove) + "\n");
        cleverSIDC.remove(toRemove);

        // testing rangeKey method
        System.out.println("\nTESTING rangeKey() method:\n");
        int key1 = cleverSIDC.getKeys()[50];
        int key2 = cleverSIDC.getKeys()[1049];
        System.out.println("Getting the number of keys (inclusive) between " +
                String.format("%08d",key1) + " and " + String.format("%08d",key2) + ": " + cleverSIDC.rangeKey(key1, key2));
    }

    public static void testGenerated(CleverSIDC cleverSIDC, Integer[] GS) {
        // use given dataset of keys for the ElasticERL
        System.out.println("Adding generated dataset to our CleverSIDC object...\n");
        for (int i = 0; i < GS.length; i++) {
            cleverSIDC.add(GS[i], "Test Value " + (i+1));
        }
        System.out.println("\nDone adding the dataset to our cleverSIDC!");

        // testing allKeys() method
        System.out.println("\nTESTING allKeys() method:\n");
        Integer[] allkeys = cleverSIDC.allKeys();
        for (int j = 0; j < allkeys.length -1; j++) {
            if (allkeys[j] != null) {
                System.out.println(String.format("%08d",allkeys[j]));
            }
        }
        System.out.println("\nDone testing allKeys()!\n");


        // testing getValues(), nextKey(), prevKey() methods
        System.out.println("\nTESTING getValue(), nextKey(), and prevKey() methods:\n");

        int testkey = cleverSIDC.getKeys()[5];
        String sTestkey = String.format("%08d",testkey);
        System.out.println("Now calling getValue() for " + sTestkey + ":");
        String value = cleverSIDC.getValue(testkey);
        System.out.println("Getting the value for key " + sTestkey + ": '" + value + "'\n");

        System.out.println("Now calling getValue() for nextKey(" + sTestkey + "):");
        int testkey2 = cleverSIDC.nextKey(testkey);
        String sTestkey2 = String.format("%08d",testkey2);
        String value2 = cleverSIDC.getValue(testkey2);
        System.out.println("Getting the value for key " + sTestkey2 + ": '" + value2 + "'\n");

        System.out.println("Now calling getValue() for prevKey(" + sTestkey + "):");
        int testkey3 = cleverSIDC.prevKey(testkey);
        String sTestkey3 = String.format("%08d",testkey3);
        String value3 = cleverSIDC.getValue(testkey3);
        System.out.println("Getting the value for key " + sTestkey3 + ": '" + value3 + "'\n");


        // testing add method
        System.out.println("\nTESTING add method:\n");
        int generatedkey = cleverSIDC.generate();
        String valueGK = "Value for generated key!";
        System.out.println("Adding entry: K = " + String.format("%08d",generatedkey) + ", V = " + "'" + valueGK + "'\n");
        cleverSIDC.add(generatedkey, valueGK);

        // print allKeys() again
        System.out.println("\nPrinting allKeys() method:\n");
        Integer[] allkeys2 = cleverSIDC.allKeys();
        for (int j = 0; j < allkeys2.length - 1; j++) {
            if (allkeys2[j] != null) {
                System.out.println(String.format("%08d",allkeys2[j]));
            }
        }
        System.out.println("\nDone printing allKeys()!\n");

        // testing remove method
        System.out.println("\nTESTING remove method:\n");
        int toRemove = cleverSIDC.getKeys()[6];
        System.out.println("Removing entry for K = " + String.format("%08d",toRemove) + "\n");
        cleverSIDC.remove(toRemove);

        // print allKeys() again
        System.out.println("\nPrinting allKeys() method:\n");
        Integer[] allkeys3 = cleverSIDC.allKeys();
        for (int j = 0; j < allkeys3.length - 1; j++) {
            if (allkeys3[j] != null) {
                System.out.println(String.format("%08d",allkeys3[j]));
            }
        }
        System.out.println("\nDone printing allKeys()!\n");


        // testing rangeKey method
        System.out.println("\nTESTING rangeKey() method:\n");
        int key1 = cleverSIDC.getKeys()[2];
        int key2 = cleverSIDC.getKeys()[9];
        System.out.println("Getting the number of keys (inclusive) between " +
                String.format("%08d",key1) + " and " + String.format("%08d",key2) + ": " + cleverSIDC.rangeKey(key1, key2));

        // print allKeys() again
        System.out.println("\nPrinting allKeys() method:\n");
        Integer[] allkeys1 = cleverSIDC.allKeys();
        for (int j = 0; j < cleverSIDC.getSize() - 1; j++) {
            if (allkeys1[j] != null) {
                System.out.println(String.format("%08d",allkeys1[j]));
            }
        }
        System.out.println("\nDone printing allKeys()!\n");
    }
}

