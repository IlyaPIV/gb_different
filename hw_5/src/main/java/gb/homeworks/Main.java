package gb.homeworks;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DBConnectorStudent dao = new DBConnectorStudent();

//        createSingleStudent(dao);

//        createThousandStudents(dao);

        Student studentById = dao.getById(100);
        System.out.println(studentById);
        //{id=100, name='Student_#100', mark=4.37356}

        List<Student> all = dao.getAll();
        System.out.println(all.size() + " records in DB");
        //999 records in DB

        String[] params3 = new String[]{"Olga", "6.66", "13"};
        String[] params2 = new String[]{"Olga", "6.66"};
        String[] params1 = new String[]{"Petia"};
        System.out.println("before: " + dao.getById(101));
        boolean updateResult1 = dao.update(101, params1);
        System.out.println("after: " + dao.getById(101));
        System.out.println("before: " + dao.getById(202));
        boolean updateResult2 = dao.update(202, params2);
        System.out.println("after: " + dao.getById(202));
        System.out.println("before: " + dao.getById(303));
        boolean updateResult3 = dao.update(303, params3);
        System.out.println("after: " + dao.getById(303));

        System.out.println("deleting result - " + dao.delete(303)); //true
        System.out.println("after deleting: " + dao.getById(303));
        System.out.println("deleting result - " + dao.delete(303)); //false
    }

    private static void createSingleStudent(DBConnectorStudent dao) {
        Student student = new Student("Vasia", 4.3f);
        int id = dao.create(student);
        System.out.println("id = " + id);
    }

    private static void createThousandStudents(DBConnectorStudent dao) {
        Random random = new Random();
        for (int i = 2; i < 1000; i++) {

            Student student = new Student("Student_#"+i, random.nextFloat(10f));
            dao.create(student);
            System.out.println(student);
        }
    }
}
