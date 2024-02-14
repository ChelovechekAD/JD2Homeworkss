package org.example.Utility;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetadataProvider {
    public static void getPrimaryKeys(DatabaseMetaData metaData, String curTable) throws SQLException {
        ResultSet rs = metaData.getPrimaryKeys(null, null, curTable);
        System.out.println("\n_____PRIMARY_KEYS_____");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | "
                    + rs.getString(3) + " | " + rs.getString(4) + " | "
                    + rs.getString(5) + " | " + rs.getString(6));
        }
    }

    public static List<String> getAllTables(DatabaseMetaData metaData) throws SQLException {
        List<String> tables = new ArrayList<>();
        ResultSet rs = metaData.getTables(null, "homework6", null, new String[]{"TABLE"});
        while (rs.next()) {
            System.out.println("\n______TABLES______");
            System.out.println(rs.getString("TABLE_NAME"));
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    public static void getTableColumns(DatabaseMetaData metaData, String curTable) throws SQLException {
        System.out.println("\n______COLUMN_METADATA_______");
        ResultSet rs = metaData.getColumns(null, null, curTable, null);
        while (rs.next()) {
            System.out.println(rs.getString("COLUMN_NAME") + " "
                    + rs.getString("TYPE_NAME"));
        }
    }
}
