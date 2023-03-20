package gb.homeworks;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAll();

    public Student getById(int id);

    public int create(Student student);

    public boolean delete(int id);

    public boolean update(int id, String[] params);
}
