package gb.homeworks.polymorphism;

import org.junit.jupiter.api.Test;

class FigureTest {

    @Test
    public void testPolymorphism(){
        Figure circle = new Circle(3.14f);
        Figure triangle = new Triangle(2.75f);
        Figure square = new Square(4.0f);

        square.printInfo();
        triangle.printInfo();
        circle.printInfo();
    }

}