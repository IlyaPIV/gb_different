package gb.homeworks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectorTest {

    private final DBConnectorStudent DAO = new DBConnectorStudent();
    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByName() {
    }

    @Test
    void create() {
        Student student = new Student("Vasia", 4.3f);
        int id = DAO.create(student);
        assertTrue(id > 0);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}