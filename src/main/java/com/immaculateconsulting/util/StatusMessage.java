package com.immaculateconsulting.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * This class is used for returning payloads to our API clients.
 *
 * @author Unogwudan
 */
public class StatusMessage {

    public int code;
    public String message;
    public String payload;

    public StatusMessage() {
    }

    public StatusMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public StatusMessage(int code, String message, String payload) {
        this.code = code;
        this.message = message;
        this.payload = payload;
    }

    /**
     * Returns an error response
     *
     * @param message error message to be returned
     * @return  a json payload
     */
    public static Response error(Status httpStatus, String message) {
        return Response.status(httpStatus)
                .entity(new StatusMessage(StatusCode.ERROR, message))
                .build();
    }

}
