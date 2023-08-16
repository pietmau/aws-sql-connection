package com.maurizio.addpet;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPetHandler implements RequestHandler<AddPetModel, Void> {
    private Connection connection = null;

    @Override
    public Void handleRequest(AddPetModel event, Context context) {
        log(context, "RECEIVED: " + event.toString());
        validateInput(event);
        try {
            Statement stmt = connectToDb();
            log(context, "Connections successful");
            stmt.executeUpdate(createSql(event));
            log(context, "Table updated");
        } catch (Exception e) {
            log(context, "ERROR! " + e.getMessage());
        }
        return null;
    }

    private static String createSql(AddPetModel event) {
        return "INSERT INTO PETS ("
                + "PetName, "
                + "OwnerName, "
                + "Species, "
                + "Age) "
                + "VALUES ('" + event.getName() + "', '"
                + event.getName() + "', '"
                + event.getSpecies() + "', +"
                + event.getAge() + ")";
    }

    private void validateInput(AddPetModel event) {
        if (event == null) {
            throw new ValidationException("Received null");
        }
        if (event.getAge() == null) {
            throw new ValidationException("Age = null");
        }
        if (event.getOwnerName() == null) {
            throw new ValidationException("Owner = null");
        }
        if (event.getSpecies() == null) {
            throw new ValidationException("Species = null");
        }
        if (event.getName() == null) {
            throw new ValidationException("Name = null");
        }
    }

    private static void log(Context context, String message) {
        context.getLogger().log(message);
    }

    private Statement connectToDb() throws SQLException {
        String jdbcUrl = "jdbc:mysql://" + System.getenv("RDS_HOSTNAME") + ":" + System.getenv("RDS_PORT") + "/" + System.getenv("RDS_DB_NAME");
        if (connection != null) {
            connection = DriverManager.getConnection(jdbcUrl, System.getenv("RDS_USERNAME"), System.getenv("RDS_PASSWORD"));
        }
        return connection.createStatement();
    }

    class ValidationException extends RuntimeException {

        public ValidationException(String message) {
            super(message);
        }
    }
}