package org.example.Utility;

import java.util.regex.Pattern;

public interface Constants {
    String PRIMARY_KEYS_TEXT = "\n_____PRIMARY_KEYS_____";
    String TABLES_TEXT = "\n______TABLES______";
    String TABLE_TEXT = "TABLE";
    String TABLE_NAME_TEXT = "TABLE_NAME";
    String COLUMN_METADATA_TEXT = "\n______COLUMN_METADATA_______";
    String COLUMN_NAME_TEXT = "COLUMN_NAME";
    String TYPE_NAME_TEXT = "TYPE_NAME";

    Pattern COMMENT_PATTERN = Pattern.compile("–.*|/\\*(.|[\\r\\n])*?\\*/");
    String sqlScriptPath = "src/main/java/org/example/SqlScripts/recreateDatabase.sql";
    String TIME_TO_LUNCH_COLUMN_NAME = "timeToLunch";
    String DATE_TIME_CREATE_COLUMN_NAME = "dateTimeCreate";
    String DATE_OF_BIRTHDAY_COLUMN_NAME = "dateOfBirthday";
    String ADDRESS_COLUMN_NAME = "address";
    String PASSPORT_COLUMN_NAME = "passport";
    String SALARY_COLUMN_NAME = "salary";
    String AGE_COLUMN_NAME = "age";
    String ID_COLUMN_NAME = "id";
}
