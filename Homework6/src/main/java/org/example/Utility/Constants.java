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
}
