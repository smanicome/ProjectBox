package com.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.test.catalog.Article;
import com.test.catalog.Batch;
import com.test.catalog.Catalog;

@Named
@SessionScoped
public class CatalogBrowserBean implements Serializable {

private static final long serialVersionUID = 2729758432756108274L;
    
    @Inject
    private Catalog catalog;
    private List<Batch> basket = new ArrayList<>();
    private int index;
    
    public int getIndex() {
    	return index;
    }
    
    public void setIndex( int index ) {
    	this.index = index;
    }

    
    
    public Article getCurrentArticle() {
        return catalog.getArticles().get( index );
    }
    
    public List<Batch> getBasket() {
        return basket;
    }
    
    public int getBasketSize() {
        int quantity = 0;
        for( Batch batch : basket ) {
            quantity += batch.getQuantity();
        }
        return quantity;
    }
    
    // --- Event handler methods ---
    
    public void processPreviousAction( ActionEvent event ) {
        if ( --index < 0 ) {
            index = catalog.getSize()-1;
        }
    }
    
    public void processNextAction( ActionEvent event ) {
        if ( ++index >= catalog.getSize() ) {
            index = 0;
        }
    }
    
    public void processAddAction( ActionEvent event ) {
        for( Batch batch : basket ) {
            if ( batch.getArticle().getIdArticle() == getCurrentArticle().getIdArticle() ) {
                batch.addOne();
                return;
            }
        }
        basket.add( new Batch( getCurrentArticle(), 1 ) );
    }
    
}