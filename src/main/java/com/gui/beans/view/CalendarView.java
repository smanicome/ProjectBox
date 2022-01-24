package com.gui.beans.view;

import javax.inject.Named;
import java.util.Date;

@Named
public class CalendarView {
    private Date minDate = new Date();

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
}
