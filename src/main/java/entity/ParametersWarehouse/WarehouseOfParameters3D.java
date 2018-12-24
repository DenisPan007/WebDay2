package entity.ParametersWarehouse;

public class WarehouseOfParameters3D extends WarehouseOfParameters2D {
    private double volume;

    public WarehouseOfParameters3D(double perimeter, double square, double volume) {
        super(perimeter, square);
        this.volume = volume;
    }

    public WarehouseOfParameters3D(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseOfParameters3D)) return false;
        if (!super.equals(o)) return false;

        WarehouseOfParameters3D that = (WarehouseOfParameters3D) o;

        return Double.compare(that.getVolume(), getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WarehouseOfParameters3D{");
        sb.append("volume=").append(volume);
        sb.append(" square=").append(getSquare());
        sb.append(" perimeter=").append(getPerimeter());
        sb.append('}');
        return sb.toString();
    }
}
