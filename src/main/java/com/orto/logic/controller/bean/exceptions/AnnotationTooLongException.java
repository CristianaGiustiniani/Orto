package com.orto.logic.controller.bean.exceptions;

import com.orto.logic.graphic_controller.exceptions.ProductException;

public class AnnotationTooLongException extends ProductException {
    public AnnotationTooLongException() {
        super("Annotation is too long");
    }
    public AnnotationTooLongException(Throwable cause) {
        super("Annotation is too long", cause);
    }
    protected AnnotationTooLongException(String message) {
        super(message);
    }
    protected AnnotationTooLongException(String message, Throwable cause) {
        super(message, cause);
    }
}
