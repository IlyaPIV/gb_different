package gb.homeworks.hw7.dao;

import gb.homeworks.hw7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findByName(String name);

    @Modifying
    @Query("UPDATE Student s SET s.name = ?2 WHERE s.id = ?1")
    public void updateName(Integer id, String name);

    @Modifying
    @Query("UPDATE Student s SET s.name = ?2, s.mark = ?3 WHERE s.id = ?1")
    public void updateName(Integer id, String name, Float mark);


}
