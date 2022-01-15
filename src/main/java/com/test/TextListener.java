package com.test;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class TextListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent arg0) throws AbortProcessingException {
        System.out.println( "Value changed" );
    }

}