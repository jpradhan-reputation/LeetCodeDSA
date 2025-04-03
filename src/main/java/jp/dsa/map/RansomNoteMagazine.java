package jp.dsa.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class RansomNoteMagazine {
    public static void main(String[] args) {
        System.out.println(canConstruct("beeee", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();


        for (Character ransomChar: ransomNote.toCharArray()) {
            if (ransomNoteMap.containsKey(ransomChar))
                ransomNoteMap.put(ransomChar, ransomNoteMap.get(ransomChar)+1);
            else
                ransomNoteMap.put(ransomChar, 1);
        }

        for (Character magazineChar: magazine.toCharArray()) {
            if (magazineMap.containsKey(magazineChar))
                magazineMap.put(magazineChar, magazineMap.get(magazineChar)+1);
            else
                magazineMap.put(magazineChar, 1);
        }

        for (Character ransomChar: ransomNoteMap.keySet()) {
            if (magazineMap.containsKey(ransomChar) && magazineMap.get(ransomChar) >= ransomNoteMap.get(ransomChar))
                continue;
            return false;
        }
        return true;
    }
}
