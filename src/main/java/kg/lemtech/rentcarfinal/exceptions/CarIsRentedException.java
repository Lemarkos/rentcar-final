package kg.lemtech.rentcarfinal.exceptions;

public class CarIsRentedException extends RuntimeException {
    public CarIsRentedException(String message) {
        super(message);
    }
}
