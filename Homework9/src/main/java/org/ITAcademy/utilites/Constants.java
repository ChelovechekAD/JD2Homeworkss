package org.ITAcademy.utilites;

import java.util.Random;

public final class Constants {
    public static final String SOMETHING_WENT_WRONG_DURING_EXECUTE_TRANSACTIONS_METHODS =
            "Something went wrong during execute transaction's methods.";
    public static final String ENTITY_MANAGER_IS_NOT_ALIVE = "Entity Manager is not alive.";
    public static final String TRANSACTION_IS_NOT_ACTIVE = "Transaction is not active.";
    public static final String ROLLBACK_ABORTED_SOMETHING_WENT_WRONG = "Rollback aborted. Something went wrong.";
    public static final String COMMIT_ABORTED_SOMETHING_WENT_WRONG = "Commit aborted. Something went wrong.";
    public static final String[] LIST_OF_NAMES = {"Artem", "Olga", "Nikita", "Karina", "Anton", "Sergey"};
    public static final String[] LIST_OF_SURNAMES = {"Chelovek", "Petruxa", "Smotrol", "Prostoi", "Slepoi", "Chudak"};
    public static final String[] LIST_OF_STREETS_NAME = {"Volgogradskaia", "Leninskaia", "Kirova", "Belinskogo"};
    public static final Integer COUNT_OF_STREETS_NAME = LIST_OF_STREETS_NAME.length;
    public static final Integer COUNT_OF_NAMES = LIST_OF_NAMES.length;
    public static final Integer COUNT_OF_SURNAMES = LIST_OF_SURNAMES.length;

    public static final Random RANDOM = new Random();

    public static final int COUNT_OF_OBJECT_EACH_TYPE = 5;
    public static final int PEOPLE_AGE_MAX_BOUND = 30;
    public static final int PEOPLE_AGE_MIN_BOUND = 10;
    public static final int ADDRESS_HOUSE_NUM_MAX_BOUND = 40;
    public static final int ADDRESS_HOUSE_NUM_MIN_BOUND = 1;

    private Constants() {

    }
}
