package gb.homeworks.hw7.service;

import gb.homeworks.hw7.dao.StudentRepository;
import gb.homeworks.hw7.entity.Student;
import gb.homeworks.hw7.exceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    public static final int STUDENTS_PER_PAGE = 50;

    private final StudentRepository repository;

    public List<Student> listAll(){
        return repository.findAll();
    }

    public Page<Student> listByPage(int pageNum){
        if (pageNum < 1) pageNum = 1;

        Pageable pageRequest = PageRequest.of(pageNum - 1, STUDENTS_PER_PAGE);

        return repository.findAll(pageRequest);
    }

    public Student findById(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            throw new StudentNotFoundException("No student with ID= " + id + " in database");
        });
    }

    public Student addNew(Student student){
        return repository.save(student);
    }

    public void updateStudent(Student student){
        Student existingStudent = repository.findById(student.getId()).orElseThrow(()->{
            throw new StudentNotFoundException("No student with ID= " + student.getId() + " in database");
        });

        existingStudent.setName(student.getName());
        existingStudent.setMark(student.getMark());

        repository.save(existingStudent);
    }

    public void deleteStudent(int id){
        repository.deleteById(id);
    }


}
