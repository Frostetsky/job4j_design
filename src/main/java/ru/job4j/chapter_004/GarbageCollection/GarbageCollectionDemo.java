package ru.job4j.chapter_004.GarbageCollection;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GarbageCollectionDemo {
    public static void main(String[] args) throws Throwable {
        User emptyuser = null;
        System.out.println(sizeOf(emptyuser));
        User user1 = new User(1, "Никита");
        System.out.println(sizeOf(user1));
        User user2 = new User();
        System.out.println(sizeOf(user2));
        user1 = null;
        user2 = null;
        Thread.sleep(3000);
    }
}
