package cn.tk.java.algorithm.limiter.tokenBucket;

/**
 *
 */
public class LimitedException extends RuntimeException{

    public LimitedException() {
    }

    public LimitedException(String message) {
        super(message);
    }

    public LimitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitedException(Throwable cause) {
        super(cause);
    }

}
