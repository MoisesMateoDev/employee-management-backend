package net.javaguides.employee_backend.model;


import java.time.LocalDateTime;

public class ErrorResponse {
    private final String type = "ErrorResponse";
    private String exceptionType;
    private LocalDateTime localDateTime;
    private String message;
    private String details;
    private StackTraceElement[] stackTrace;

    public ErrorResponse(String exceptionType, LocalDateTime localDateTime, String message, String details,  StackTraceElement[] stackTrace) {
        this.exceptionType = exceptionType;
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
        this.stackTrace = stackTrace;
    }

    public ErrorResponse() {
    }

    public String getType(){
        return this.type;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "type='" + type + '\'' +
                ", localDateTime=" + localDateTime +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
