package business.persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static ItemMapper itemMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            itemMapper = new ItemMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
            stmt.execute("DROP table if exists fog_test.ordered_materials" );
            stmt.execute("create table " + TESTDATABASE + ".ordered_materials LIKE " + DATABASE + ".ordered_materials;" );
            stmt.execute(
                    "insert into fog_test.ordered_materials values " +
                            "(1,1,200,225, 300, 1200, '2021-05-20', 'forespørgelse'), " +
                            "(2,2,400,225, 600, 1000, '2021-05-19', 'forespørgelse'), " +
                            "(3,4,500,225, 150, 850, '2021-05-18', 'forespørgelse')");
        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    void insertIntoOrdered_materials() {
    }

    @Test
    void removeFromOrdered_materials() {
    }

    @Test
    void getBOMEntries() {
    }
}