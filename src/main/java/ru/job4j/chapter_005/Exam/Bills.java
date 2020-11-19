package ru.job4j.chapter_005.Exam;

public enum Bills {
    ONE_VM {
        int getOneVM() { return 1; }
    },
    FIVE_VM {
        int getFiveVM() { return 5; }
    },
    TEN_VM {
        int getTenVM() { return 10; }
    },
    TWENTY_VM {
        int getTwentyVM() { return 20; }
    },
    FIFTY_VM {
        int getFiftyVM() { return 50; }
    },
    ONE_HUNDRED {
        int getOneHundredVM() { return 100; }
    },
    FIVE_HUNDRED {
        int getFiveHundredVM() { return 500; }
    }
}
