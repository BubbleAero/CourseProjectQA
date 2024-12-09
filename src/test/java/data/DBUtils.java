package data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBUtils {
    static String url = System.getProperty("db.url", "jdbc:mysql://localhost:3306/app");
    static String user = "app";
    static String password = "pass";

    @SneakyThrows
    public static void cleanTable(String tableName) {
        val runner = new QueryRunner();
        val deleteQuery = String.format("DELETE FROM %s", tableName);  // Safely format table name
        try (val conn = DriverManager.getConnection(url, user, password)) {
            runner.update(conn, deleteQuery);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        String statusSQL = "SELECT status FROM payment_entity";
        return getStatus(statusSQL);
    }


    @SneakyThrows
    private static String getStatus(String query) {
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(url, user, password)) {
            String status = runner.query(conn, query, new ScalarHandler<>());
            return status != null ? status : "No status found";
        }
    }

    @SneakyThrows
    public static List<String> getAllStatuses() {
        val runner = new QueryRunner();
        String query = "SELECT status FROM payment_entity";
        try (val conn = DriverManager.getConnection(url, user, password)) {
            return runner.query(conn, query, new ColumnListHandler<>());
        }
    }
}
