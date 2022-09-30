package com.MiniLes.exception;

public class ErrorResponse {

    private final int status;

    private final Object message;

    private final long timestamp;

    public ErrorResponse(int status, Object message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public Object getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
