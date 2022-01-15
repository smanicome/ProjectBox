package com.test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class NextListener implements Serializable, ActionListener {

    private static final long serialVersionUID = -7752358388239085979L;
    
    @Inject
    private CatalogBrowserBean catalogBrowserBean; 
    
    
    @Override
    public void processAction( ActionEvent event ) throws AbortProcessingException {
        catalogBrowserBean.setIndex( catalogBrowserBean.getIndex() + 1 );
    }
    
}