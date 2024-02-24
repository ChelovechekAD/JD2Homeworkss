package org.example.Utility;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utility.Constants.*;

public class MetadataProvider {
    public static void getPrimaryKeys(DatabaseMetaData metaData, String curTable) throws SQLException {
        ResultSet rs = metaData.getPrimaryKeys(null, null, curTable);

        System.out.println(PRIMARY_KEYS_TEXT);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | "
                    + rs.getString(3) + " | " + rs.getString(4) + " | "
                    + rs.getString(5) + " | " + rs.getString(6));
        }
    }

    public static List<String> getAllTables(DatabaseMetaData metaData) throws SQLException {
        List<String> tables = new ArrayList<>();

        ResultSet rs = metaData.getTables(null, null, null, new String[]{TABLE_TEXT});

        System.out.println(TABLES_TEXT);
        while (rs.next()) {
            System.out.println(rs.getString(TABLE_NAME_TEXT));
            tables.add(rs.getString(TABLE_NAME_TEXT));
        }
        return tables;
    }

    public static void getTableColumns(DatabaseMetaData metaData, String curTable) throws SQLException {
        System.out.println(COLUMN_METADATA_TEXT);
        ResultSet rs = metaData.getColumns(null, null, curTable, null);
        while (rs.next()) {
            System.out.println(rs.getString(COLUMN_NAME_TEXT) + " "
                    + rs.getString(TYPE_NAME_TEXT));
        }
    }
}
