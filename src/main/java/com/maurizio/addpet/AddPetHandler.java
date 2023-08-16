package com.maurizio.addpet;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPetHandler implements RequestHandler<AddPetModel, Void> {
    private String dbName = System.getenv("RDS_DB_NAME");
    private String userName = System.getenv("RDS_USERNAME");
    private String password = System.getenv("RDS_PASSWORD");
    private String hostname = System.getenv("RDS_HOSTNAME");
    private String port = System.getenv("RDS_PORT");

    @Override
    public Void handleRequest(AddPetModel event, Context context) {
        log(context, "RECEIVED: " + event.toString());
        validateInput(event);
        try {
            Statement stmt = getStatement();
            log(context, "Connections successful");
            String update = "INSERT INTO PETS ("
                    + "PetName, "
                    + "OwnerName, "
                    + "Species, "
                    + "Age) "
                    + "VALUES ('Travis', 'Maurizio', 'Cockatiel', 3)";
            stmt.executeUpdate(update);
            log(context, "table updated");
        } catch (Exception e) {
            log(context, "ERROR! " + e.getMessage());
        }
        return null;
    }

    private void validateInput(AddPetModel event) {
        if (event == null) {
            throw new ValidationException("Received null");
        }
        if (event.getAge() == null) {
            throw new ValidationException("Age = null");
        }
        if (event.getOwnerName()== null) {
            throw new ValidationException("Owner = null");
        }
        if (event.getSpecies()== null) {
            throw new ValidationException("Species = null");
        }
        if (event.getName()== null) {
            throw new ValidationException("Name = null");
        }
    }

    private static void log(Context context, String message) {
        context.getLogger().log(message);
    }

    private Statement getStatement() throws SQLException {
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
        Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
        Statement stmt = conn.createStatement();
        return stmt;
    }

    class ValidationException extends RuntimeException {

        public ValidationException(String message) {
            super(message);
        }
    }
}