package entity.ParametersWarehouse;

public class WarehouseOfParameters2D extends WarehouseOfParameters {
    private static final double DEFAULT_VALUE = 0;
    private double perimeter;
    private double square;


    public WarehouseOfParameters2D(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public WarehouseOfParameters2D() {
        this.perimeter = DEFAULT_VALUE;
        this.square = DEFAULT_VALUE;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseOfParameters2D)) return false;

        WarehouseOfParameters2D that = (WarehouseOfParameters2D) o;

        if (Double.compare(that.getPerimeter(), getPerimeter()) != 0) return false;
        return Double.compare(that.getSquare(), getSquare()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPerimeter());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSquare());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WarehouseOfParameters2D{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append('}');
        return sb.toString();
    }

}
