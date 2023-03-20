package gb.homeworks;

import org.hibernate.Session;

import java.util.List;

public class HibernateRequests {

    public static int addNewStudent(Student newStudent) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(newStudent);
            session.getTransaction().commit();

            return newStudent.getId();
        }
    }

    public static Student getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();

            return student;
        }
    }

    public static List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            List<Student> students = session.createQuery("SELECT s from Student s", Student.class).getResultList();

            session.getTransaction().commit();
            return students;
        }
    }

    public static boolean update(int id, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student == null) {
                session.getTransaction().commit();
                return false;
            }

            student.setName(params[0]);
            if (params.length == 2)
            {
                student.setMark(Float.parseFloat(params[1]));
            }
            session.persist(student);
            session.getTransaction().commit();
            return true;
        }
    }

    public static boolean delete(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student == null) {
                session.getTransaction().commit();
                return false;
            }
            session.remove(student);

            session.getTransaction().commit();
            return true;
        }
    }
}
