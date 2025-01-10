public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public static void main(String[] args) {
        var vector = new Vector3D(5.0, 2.5, -3.2);
        System.out.println(vector);
        System.out.println(vector.getMagnitude());
        System.out.println(vector.normalize());
        var otherVector = new Vector3D(-3.1, 7.0, 2.4);
        System.out.println(vector.add(otherVector));
        System.out.println(vector.multiply(2.0));
        System.out.println(vector.dotProduct(otherVector));
        System.out.println(vector.angleBetween(otherVector));
        System.out.println(vector.crossProduct(otherVector));
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String toString() {
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ", " + String.format("%.2f", z) + ")";
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        var magnitude = getMagnitude();

        if (magnitude == 0) {
            throw new IllegalStateException();
        }

        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3D multiply(double value) {
        return new Vector3D(x * value, y * value, z * value);
    }

    public double dotProduct(Vector3D other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public double angleBetween(Vector3D other) {
        try {
            return Math.acos(dotProduct(other) / (getMagnitude() * other.getMagnitude()));
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public Vector3D crossProduct(Vector3D other) {
        return new Vector3D(y * other.getZ() - z * other.getY(), z * other.getX() - x * other.getZ(), x * other.getY() - y * other.getX());
    }
}
