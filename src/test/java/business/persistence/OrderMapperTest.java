package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;
    private static OrderMapper orderMapper;
    int users_id = 1;
    int length = 200;
    int height = 225;
    int width = 300;
    int price = 1200;
    String date = "";
    String status = "forespørgelse";

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
            orderMapper = new OrderMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
            stmt.execute("DROP table if exists fog_test.order" );
            stmt.execute("create table " + TESTDATABASE + ".order LIKE " + DATABASE + ".order;" );
            stmt.execute(
                    "insert into fog_test.order values " +
                            "(1,1,200,225, 300, 1200, '2021-05-20', 'forespørgelse'), " +
                            "(2,2,400,225, 600, 1000, '2021-05-19', 'forespørgelse'), " +
                            "(3,4,500,225, 150, 850, '2021-05-18', 'forespørgelse')");
        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    void insertIntoOrder() throws UserException {

        Order order = new Order(users_id, length, height, width, price, status);
        orderMapper.insertIntoOrder(order, 1);
        assertEquals(4, orderMapper.getOrderId(1));

    }

    @Test
    void getPrice() throws UserException {
        int id = 1;
       orderMapper.getPrice(id);
        Order order = new Order(users_id, length, height, width, price, status);
        assertEquals(1200, order.getPrice());
    }

    @Test
    void changeStatus() throws UserException {
        orderMapper.changeStatus("godkendt",1);
        assertEquals("godkendt", orderMapper.getStatus(1));
    }

    @Test
    void removeOrder() throws UserException {
        orderMapper.removeOrder(3);
        assertEquals(2,orderMapper.getOrders().size());
    }
}