package gb.homeworks;


import java.util.List;

public class DBConnectorStudent implements StudentDAO {

    @Override
    public List<Student> getAll() {
        return HibernateRequests.getAll();
    }

    @Override
    public Student getById(int id) {
        return HibernateRequests.getById(id);
    }

    @Override
    public int create(Student student) {
        return HibernateRequests.addNewStudent(student);
    }

    @Override
    public boolean delete(int id) {
        return HibernateRequests.delete(id);
    }

    @Override
    public boolean update(int id, String[] params) {
        if (params.length == 1 || params.length ==2) {
            return HibernateRequests.update(id, params);
        } else return false;
    }
}
