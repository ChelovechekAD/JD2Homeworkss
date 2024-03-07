package org.example.Utils;

import java.util.Random;

public final class Constants {
    public static final String SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS =
            "Something went wrong during execute transaction's methods.";
    public static final String ENTITY_MANAGER_IS_NOT_ALIVE = "Entity Manager is not alive.";
    public static final String TRANSACTION_IS_NOT_ACTIVE = "Transaction is not active.";
    public static final String ROLLBACK_ABORTED_SOMETHING_WENT_WRONG = "Rollback aborted. Something went wrong.";
    public static final String COMMIT_ABORTED_SOMETHING_WENT_WRONG = "Commit aborted. Something went wrong.";
    public static final String[] LIST_OF_DESCRIPTIONS = {"Boring", "Nope", "Amazing", "Hard", "Easy", "Broken"};
    public static final String STREET_TEXT = "Volgogradskaia";
    public static final String TOWN_TEXT = "Minsk";
    public static final String TASK_TEXT = "Task";
    public static final int COUNT_OF_TASK_GENERATE = 10;
    public static final Random RANDOM = new Random();

    public static final int TASK_NUMBER_BOUND = 10;
    public static final int TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE = 100;
    public static final int MAX_COST_BOUND = 100000;
    public static final int MIN_COST_BOUND = 10000;

    private Constants() {

    }
}
