package za.ac.cput.helper;

/**
 * Common validation and utility methods used by FundiShop factories and services.
 */
public final class Helper {

    private Helper() {
        // Utility class
    }

    /**
     * Ensures that an object is not null.
     */
    public static <T> T requireNonNull(T value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        return value;
    }

    /**
     * Ensures that a String is not null or blank.
     */
    public static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }
        return value.trim();
    }

    /**
     * Ensures that a number is positive.
     */
    public static <T extends Number> T requirePositive(T value, String fieldName) {
        if (value == null || value.doubleValue() <= 0) {
            throw new IllegalArgumentException(fieldName + " must be greater than zero");
        }
        return value;
    }

    /**
     * Ensures that a number is zero or positive.
     */
    public static <T extends Number> T requireNonNegative(T value, String fieldName) {
        if (value == null || value.doubleValue() < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
        return value;
    }

    /**
     * Ensures that an integer is not negative.
     */
    public static Integer requireNonNegativeInteger(Integer value, String fieldName) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
        return value;
    }
}
