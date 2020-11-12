package com.BASofttech.caipiao.model;

import org.litepal.crud.LitePalSupport;

/**
 * created by stray cat on 2019/6/19.
 */
public class DCBModel extends LitePalSupport {
    private int id;
   private String dcbBall;
   private String dcbDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDcbDate() {
        return dcbDate;
    }

    public void setDcbDate(String dcbDate) {
        this.dcbDate = dcbDate;
    }

    public String getDcbBall() {
        return dcbBall;
    }

    public void setDcbBall(String dcbBall) {
        this.dcbBall = dcbBall;
    }
}
