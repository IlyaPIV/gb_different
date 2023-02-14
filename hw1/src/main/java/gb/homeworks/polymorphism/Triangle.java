package gb.homeworks.polymorphism;

public class Triangle extends Figure {
    public Triangle(float square) {
        super(square, 3);
    }

    @Override
    public void printInfo() {
        System.out.println("Треугольник площадью " + this.square + " имеет " + this.angles + " углов.");
    }
}
