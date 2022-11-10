package org.studenttestscore.exception;

public class ScoringExceptions extends RuntimeException{
    public ScoringExceptions(String message) {
        super(message);
    }

    public ScoringExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
