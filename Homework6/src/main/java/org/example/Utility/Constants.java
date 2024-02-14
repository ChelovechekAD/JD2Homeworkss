package org.example.Utility;

import java.util.regex.Pattern;

public interface Constants {
    Pattern COMMENT_PATTERN = Pattern.compile("–.*|/\\*(.|[\\r\\n])*?\\*/");
    String sqlScriptPath = "src/main/java/org/example/SqlScripts/recreateDatabase.sql";
}
