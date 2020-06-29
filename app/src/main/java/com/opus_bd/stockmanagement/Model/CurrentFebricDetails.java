package com.opus_bd.stockmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentFebricDetails {

    @SerializedName("masterId")
    @Expose
    private Integer masterId;
    @SerializedName("detailsId")
    @Expose
    private Integer detailsId;
    @SerializedName("buyerName")
    @Expose
    private String buyerName;
    @SerializedName("orderNo")
    @Expose
    private String orderNo;
    @SerializedName("lotNo")
    @Expose
    private String lotNo;
    @SerializedName("stoNo")
    @Expose
    private String stoNo;
    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("febrics")
    @Expose
    private String febrics;
    @SerializedName("dia")
    @Expose
    private String dia;
    @SerializedName("gsm")
    @Expose
    private String gsm;
    @SerializedName("week")
    @Expose
    private String week;
    @SerializedName("GQTY")
    @Expose
    private Double gQTY;
    @SerializedName("finishQTY")
    @Expose
    private Double finishQTY;
    @SerializedName("totalQTY")
    @Expose
    private Double totalQTY;
    @SerializedName("PSYRcvMtr")
    @Expose
    private Double pSYRcvMtr;
    @SerializedName("totalRoll")
    @Expose
    private Double totalRoll;
    @SerializedName("statusId")
    @Expose
    private Object statusId;

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getStoNo() {
        return stoNo;
    }

    public void setStoNo(String stoNo) {
        this.stoNo = stoNo;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFebrics() {
        return febrics;
    }

    public void setFebrics(String febrics) {
        this.febrics = febrics;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Double getGQTY() {
        return gQTY;
    }

    public void setGQTY(Double gQTY) {
        this.gQTY = gQTY;
    }

    public Double getFinishQTY() {
        return finishQTY;
    }

    public void setFinishQTY(Double finishQTY) {
        this.finishQTY = finishQTY;
    }

    public Double getTotalQTY() {
        return totalQTY;
    }

    public void setTotalQTY(Double totalQTY) {
        this.totalQTY = totalQTY;
    }

    public Double getPSYRcvMtr() {
        return pSYRcvMtr;
    }

    public void setPSYRcvMtr(Double pSYRcvMtr) {
        this.pSYRcvMtr = pSYRcvMtr;
    }

    public Double getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Double totalRoll) {
        this.totalRoll = totalRoll;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(Object statusId) {
        this.statusId = statusId;
    }
}
