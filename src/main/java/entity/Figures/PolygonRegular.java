package entity.Figures;

public class PolygonRegular extends Figure {
    private static final int DEFAULT_EDGE_NUMBER = 4;
    private  static final double DEFAULT_EDGE_SIZE = 1;
    private Point3d middlePoint;
    private int edgeNumber;
    private double edgeSize;

    public PolygonRegular(Point3d middlePoint, int edgeNumber, double edgeSize) {
        this();
        if (middlePoint != null && edgeNumber > 0 && edgeSize > 0) {
            this.middlePoint = middlePoint;
            this.edgeNumber = edgeNumber;
            this.edgeSize = edgeSize;
        }
    }

    public PolygonRegular() {
        this.middlePoint = new Point3d();
        this.edgeNumber = DEFAULT_EDGE_NUMBER;
        this.edgeSize = DEFAULT_EDGE_SIZE;
    }

    public Point3d getMiddle() {
        return new Point3d(middlePoint.getX(), middlePoint.getY(), middlePoint.getZ());
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public double getEdgeSize() {
        return edgeSize;
    }

    public void setMiddlePoint(Point3d middlePoint) {
        this.middlePoint = middlePoint;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public void setEdgeSize(double edgeSize) {
        this.edgeSize = edgeSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolygonRegular)) return false;

        PolygonRegular that = (PolygonRegular) o;

        if (getEdgeNumber() != that.getEdgeNumber()) return false;
        if (Double.compare(that.getEdgeSize(), getEdgeSize()) != 0) return false;
        return getMiddle().equals(that.getMiddle());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMiddle().hashCode();
        result = 31 * result + getEdgeNumber();
        temp = Double.doubleToLongBits(getEdgeSize());
        result = 31 * result + (int) (temp);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PolygonRegular{" + "\n");
        sb.append("middlePoint=").append(middlePoint);
        sb.append("edgeNumber=").append(edgeNumber);
        sb.append(", edgeSize=").append(edgeSize);
        sb.append("\n" + " }");
        return sb.toString();
    }

}
