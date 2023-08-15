package com.maurizio;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class CreateTable implements RequestHandler<Map<String, String>, Void> {
    private String dbName = System.getenv("RDS_DB_NAME");
    private String userName = System.getenv("RDS_USERNAME");
    private String password = System.getenv("RDS_PASSWORD");
    private String hostname = System.getenv("RDS_HOSTNAME");
    private String port = System.getenv("RDS_PORT");

    @Override
    public Void handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
        try (Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
             Statement stmt = conn.createStatement();
        ) {
            logger.log("Connections successful");
            String createTable = "CREATE TABLE PETS("
                    + "Id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "PetName VARCHAR (20) NOT NULL, "
                    + "OwnerName VARCHAR (20) NOT NULL, "
                    + "Species VARCHAR (20) NOT NULL, "
                    + "Age INT)";
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            logger.log("ERROR! " + e.getMessage());
        }

        return null;
    }
}