
package com.opus_bd.stockmanagement.Model.GrayFabric.RackIn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFabricDetailsViewModel {

    @SerializedName("Id")
    @Expose
    private Integer id;
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
    private Object dia;
    @SerializedName("gsm")
    @Expose
    private Object gsm;
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
    private Integer statusId;
    @SerializedName("rollId")
    @Expose
    private Object rollId;
    @SerializedName("detailsIdArray")
    @Expose
    private Object detailsIdArray;
    @SerializedName("IdArray")
    @Expose
    private Object idArray;
    @SerializedName("statusIdArray")
    @Expose
    private Object statusIdArray;
    @SerializedName("grayFabricDetailsViewModels")
    @Expose
    private Object grayFabricDetailsViewModels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Object getDia() {
        return dia;
    }

    public void setDia(Object dia) {
        this.dia = dia;
    }

    public Object getGsm() {
        return gsm;
    }

    public void setGsm(Object gsm) {
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Object getRollId() {
        return rollId;
    }

    public void setRollId(Object rollId) {
        this.rollId = rollId;
    }

    public Object getDetailsIdArray() {
        return detailsIdArray;
    }

    public void setDetailsIdArray(Object detailsIdArray) {
        this.detailsIdArray = detailsIdArray;
    }

    public Object getIdArray() {
        return idArray;
    }

    public void setIdArray(Object idArray) {
        this.idArray = idArray;
    }

    public Object getStatusIdArray() {
        return statusIdArray;
    }

    public void setStatusIdArray(Object statusIdArray) {
        this.statusIdArray = statusIdArray;
    }

    public Object getGrayFabricDetailsViewModels() {
        return grayFabricDetailsViewModels;
    }

    public void setGrayFabricDetailsViewModels(Object grayFabricDetailsViewModels) {
        this.grayFabricDetailsViewModels = grayFabricDetailsViewModels;
    }

}
