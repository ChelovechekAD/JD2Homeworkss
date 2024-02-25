package org.example.Utility;

import lombok.Getter;
import org.example.TemplateSql.InsertTemplates;
import org.example.TemplateSql.Statements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class DatabaseFunc {

    @Getter
    private static final Connection connection = JDBCProvider.getConnection();
    private static final Statement statement;


    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recreateTable() throws SQLException {
        connection.setAutoCommit(false);
        try {
            executeBatchedSQL(Constants.sqlScriptPath, connection, 2);

        } catch (Exception e) {
            connection.rollback();
        }
    }

    public static void selectOnAge(Integer age) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM jd2lessons.people WHERE age>=" + age + " ORDER BY \"dateTimeCreate\"");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " | " + resultSet.getString(3)
                    + " | " + resultSet.getString(4) + " | " + resultSet.getString(5)
                    + " | " + resultSet.getString(6) + " | " + resultSet.getString(7)
                    + " | " + resultSet.getString(8));
        }
    }

    private static void executeBatchedSQL(String scriptFilePath, Connection connection, int batchSize) throws Exception {
        List<String> sqlStatements = parseSQLScript(scriptFilePath);
        executeSQLBatches(connection, sqlStatements, batchSize);
    }

    private static List<String> parseSQLScript(String scriptFilePath) throws IOException {
        List<String> sqlStatements = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {
            StringBuilder currentStatement = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher commentMatcher = Constants.COMMENT_PATTERN.matcher(line);
                line = commentMatcher.replaceAll("");

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                currentStatement.append(line).append(" ");

                if (line.endsWith(";")) {
                    sqlStatements.add(currentStatement.toString());
                    System.out.println(currentStatement);
                    currentStatement.setLength(0);
                }
            }
        }
        return sqlStatements;
    }

    private static void executeSQLBatches(Connection connection, List<String> sqlStatements, int batchSize)
            throws SQLException {
        int count = 0;
        Statement statement = connection.createStatement();

        for (String sql : sqlStatements) {
            statement.addBatch(sql);
            count++;

            if (count % batchSize == 0) {
                System.out.println("Executing batch");
                statement.executeBatch();
                statement.clearBatch();
            }
        }
        if (count % batchSize != 0) {
            statement.executeBatch();
        }
        connection.commit();
    }


}
