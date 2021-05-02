package com.swasth.smartlaundry.util;

public class InvalidSystemClockException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 8758884073693556448L;

    public InvalidSystemClockException() {
        super();
    }

    public InvalidSystemClockException(String message) {
        super(message);
    }

    public InvalidSystemClockException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSystemClockException(Throwable cause) {
        super(cause);
    }

    protected InvalidSystemClockException(String message,
                                          Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}	