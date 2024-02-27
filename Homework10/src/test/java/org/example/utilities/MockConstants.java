package org.example.utilities;

import java.util.Random;

public final class MockConstants {
    public static final String TASK_TYPE = "task";
    public static final String HOME_TASK_TYPE = "hometask";
    public static final String WORK_TASK_TYPE = "worktask";

    public static final Integer COUNT_OF_TASK_PER_REQUEST = 10;
    public static final Integer COUNT_OF_TASK_RANDOM_GEN = 10;
    public static final String TEST_DESCRIPTION = "Nothing here :)";
    public static final String[] LIST_OF_DESCRIPTIONS = {"Boring", "Nope", "Amazing", "Hard", "Easy", "Broken"};
    public static final Random random = new Random();



    private MockConstants() {

    }
}
