package gb.homeworks.polymorphism;

public class Circle extends Figure {
    public Circle(float square) {
        super(square, 0);
    }

    @Override
    public void printInfo() {
        System.out.println("Круг площадью " + this.square + " имеет " + this.angles + " углов.");
    }
}
