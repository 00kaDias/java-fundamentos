package entities.enums;

public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIVERED(3);

    private int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
