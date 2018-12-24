package entity.Figures;

public class Point3d extends Figure {
    private static final double ORIGIN_OF_AXIS = 0;
    private double x;
    private double y;
    private double z;

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3d() {
        this.x = ORIGIN_OF_AXIS;
        this.y = ORIGIN_OF_AXIS;
        this.z = ORIGIN_OF_AXIS;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3d)) return false;
        Point3d point = (Point3d) o;
        return Double.compare(point.getX(), getX()) == 0 &&
                Double.compare(point.getY(), getY()) == 0 &&
                Double.compare(point.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return (int)(31 * x + y + z);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point3d{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append('}' + "\n");
        return sb.toString();
    }

}
