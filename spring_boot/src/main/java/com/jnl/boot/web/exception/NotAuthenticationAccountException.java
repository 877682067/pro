package com.jnl.boot.web.exception;


import org.apache.shiro.authc.AccountException;

public class NotAuthenticationAccountException extends AccountException {
    /**
     */
    public NotAuthenticationAccountException() {
        super();
    }

    /**
     * <p>
     *
     * @param msg the detail message.
     */
    public NotAuthenticationAccountException(String msg) {
        super(msg);
    }
    public NotAuthenticationAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UnknownAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public NotAuthenticationAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
