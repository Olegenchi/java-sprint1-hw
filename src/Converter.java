public class Converter {

    double length;
    double cal;

    Converter(double length, double cal) {
        this.length = length;
        this.cal = cal;
    }

    public double getLength(int steps) {
        return ((steps * this.length) / 100000);
    }

    public double getCal(int steps) {
        return ((steps * this.cal) / 1000);
    }
}
