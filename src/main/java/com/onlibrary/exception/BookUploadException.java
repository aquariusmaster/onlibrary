package com.onlibrary.exception;

import java.io.IOException;

/**
 * Created by harkonnen on 22.03.16.
 */
public class BookUploadException extends IOException {

    public BookUploadException(String message, IOException e) {
        super(message, e);
    }

    public BookUploadException(String message) {
        super(message);
    }
}
