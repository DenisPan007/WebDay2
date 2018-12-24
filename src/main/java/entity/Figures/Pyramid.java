package entity.Figures;

public class Pyramid extends Figure {
    private Point3d topPoint;
    private PolygonRegular basis;

    public Pyramid(Point3d topPoint, PolygonRegular basis) {
        this.topPoint = topPoint;
        this.basis = basis;
    }
    public Pyramid(Point3d topPoint, Point3d middlePoint, int numberSize, double edgeSize) {
        this.topPoint = topPoint;
        this.basis = new PolygonRegular(middlePoint, numberSize, edgeSize);
    }
    public Pyramid(double xTop, double yTop, double zTop, double xMiddle, double yMiddle, double zMiddle,
                   int numberSize, double edgeSize) {
        this.topPoint = new Point3d(xTop, yTop, zTop);
        Point3d middlePoint = new Point3d(xMiddle, yMiddle, zMiddle);
        this.basis = new PolygonRegular(middlePoint, numberSize, edgeSize);
    }
    public Pyramid() {
        this.topPoint = new Point3d();
        this.basis = new PolygonRegular();
    }

    public Point3d getTopPoint() {
        return new Point3d(topPoint.getX(),topPoint.getY(),topPoint.getZ());
    }

    public void setTopPoint(Point3d topPoint) {
        this.topPoint = topPoint;
    }
    public PolygonRegular getBasis() {
        return new PolygonRegular(basis.getMiddle(),basis.getEdgeNumber(),basis.getEdgeSize());
    }

    public void setBasis(PolygonRegular basis) {
        this.basis = basis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;

        Pyramid pyramid = (Pyramid) o;

        if (!getTopPoint().equals(pyramid.getTopPoint())) return false;
        return getBasis().equals(pyramid.getBasis());
    }

    @Override
    public int hashCode() {
        int result = getTopPoint().hashCode();
        result = 31 * result + getBasis().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pyramid{" + "\n");
        sb.append("topPoint=").append(topPoint);
        sb.append("basis=").append(basis);
        sb.append("\n" + '}');
        return sb.toString();
    }

}
