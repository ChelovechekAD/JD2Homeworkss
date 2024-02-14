package org.example;


import org.example.Utility.DatabaseFunc;
import org.example.Utility.MetadataProvider;

import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {

        //DATABASE OPERATIONS PART
        DatabaseFunc.recreateTable();
        DatabaseFunc.insertData();
        DatabaseFunc.selectOnAge(21);
        DatabaseMetaData metaData = DatabaseFunc.getConnection().getMetaData();


        //METADATA PART
        MetadataProvider.getAllTables(metaData);
        String curTable = "people";
        MetadataProvider.getPrimaryKeys(metaData, curTable);
        MetadataProvider.getTableColumns(metaData, curTable);


    }


}
