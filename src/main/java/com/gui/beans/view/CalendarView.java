package com.gui.beans.view;

import javax.inject.Named;
import java.util.Date;

/**
 * <h1>Date view</h1>
 * <p>Create a new date</p>
 */
@Named
public class CalendarView {
    /**
     * Set new date
     */
    private Date minDate = new Date();

    /**
     * Get current date setted
     * @return minDate, Date type
     */
    public Date getMinDate() {
        return minDate;
    }

    /**
     * Set current date
     * @param minDate, type Date
     */
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
}
