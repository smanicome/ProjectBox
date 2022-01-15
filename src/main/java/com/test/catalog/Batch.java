package com.test.catalog;

import java.security.InvalidParameterException;

public class Batch {

    private Article article;
    private int quantity;
        
    public Batch( Article article, int quantity ) {
        if ( article == null )
            throw new NullPointerException( "article cannot be null" );
        if ( quantity < 1 ) 
            throw new InvalidParameterException( "quantity must be a positive number" );
        this.article = article;
        this.quantity = quantity;
    }
    
    public Article getArticle() {
        return article;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void addOne() {
        quantity++;
    }
    
}