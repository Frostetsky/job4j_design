package ru.job4j.chapter_001.map;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        char[] leftch = left.toCharArray();
        char[] rightch = right.toCharArray();
        Arrays.sort(leftch);
        Arrays.sort(rightch);
        return Arrays.equals(leftch,rightch);
    }
}
