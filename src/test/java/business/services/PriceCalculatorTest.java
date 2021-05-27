package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";
    private static Database database;
    private static PriceCalculator priceCalculator;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            priceCalculator = new PriceCalculator(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
            stmt.execute("DROP table if exists fog_test.materials");
            stmt.execute("create table " + TESTDATABASE + ".materials LIKE " + DATABASE + ".materials;" );
            stmt.execute("insert into fog_test.materials values " +
                            "(1, '97x97 mm. trykimp. Stolpe', 41, 'meter'), " +
                            "(2, '45x195 mm. spærtræ ubh.', 41, 'meter'), " +
                            "(3, '600 cm. Plastmo Ecolite blåtonet', 250, 'stk')");

        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }



    @Test
    void calcPrice() throws UserException {
        int price = priceCalculator.calcPrice(1000, 3, 1);
        assertEquals(1230, price);
    }
}