package gb.homeworks.polymorphism;

public abstract class Figure {
    protected float square;
    protected final int angles;

    public Figure(float square, int anglesCount) {
        this.square = square;
        this.angles = anglesCount;
    }

    public abstract void printInfo();
}
