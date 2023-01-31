package com.company;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("EqualValues1", 1);
        dictionary.put("EqualValues2", 1);
        dictionary.put("ValueKey1", 2);
        dictionary.put("ValueKey2", 3);

        testGetKeys(dictionary);
        testGetValues(dictionary);
        testDeleteKeys(dictionary);
        testDeleteValue(dictionary);
    }

    private static void testGetKeys(Dictionary dictionary) {
        Collection<String> keys = dictionary.getKeyList(1);
        System.out.println(keys.toString());
    }

    public static void testGetValues(Dictionary dictionary) {
        Collection<Integer> values = dictionary.getValueList();
        System.out.println(values);
    }

    private static void testDeleteKeys(Dictionary dictionary) {
        boolean result = dictionary.deleteKeys(1);

        if (result && dictionary.get("EqualValues1") == null && dictionary.get("EqualValues2") == null) {
            System.out.println("Deletion complete. (test succeed)");
        } else {
            System.out.println("Deletion is failed :( (test failed)");
        }

        result = dictionary.deleteKeys(5);
        if (result) {
            System.out.println("Deletion complete. (test failed)");
        } else {
            System.out.println("Deletion is failed, value doesn't exist :( (test succeed)");
        }
    }

    private static void testDeleteValue(Dictionary dictionary) {
        boolean result = dictionary.deleteValue("EqualValues1");
        if (result && dictionary.get("EqualValues1") != null) {
            System.out.println("Deletion is failed :( (test failed)");
        } else {
            System.out.println("Deletion complete. (test succeed)");
        }

        result = dictionary.deleteValue("NonExistingKey");
        if (result) {
            System.out.println("Deletion complete. (test failed)");
        } else {
            System.out.println("Deletion is failed, key doesn't exist :( (test succeed)");
        }
    }
}