package gb.homeworks.builder;

import org.junit.jupiter.api.Test;


class PersonTest {
    @Test
    public void testCreationPerson(){
        Person testPerson = new Person.Builder("Name", "Surname", "Middle")
                                            .gender("male")
                                            .fromCountry("USA")
                                            .withAddress("Springfield, 12-345, Main str. 17")
                                            .phoneNumber("+1-23-751-654-8463")
                                            .build();
        System.out.println(testPerson);
    }
}