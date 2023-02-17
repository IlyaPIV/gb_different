package gb.homeworks.polymorphism;

public class Square extends Figure {
    public Square(float square) {
        super(square, 4);
    }

    @Override
    public void printInfo() {
        System.out.println("Квадрат площадью " + this.square + " имеет " + this.angles + " углов.");
    }
}
