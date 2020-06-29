
package com.opus_bd.stockmanagement.Model.GrayFabric.RackIn;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCurrentGrayFebricDetails {

    @SerializedName("Id")
    @Expose
    private Object id;
    @SerializedName("masterId")
    @Expose
    private Object masterId;
    @SerializedName("detailsId")
    @Expose
    private Object detailsId;
    @SerializedName("buyerName")
    @Expose
    private Object buyerName;
    @SerializedName("orderNo")
    @Expose
    private Object orderNo;
    @SerializedName("lotNo")
    @Expose
    private Object lotNo;
    @SerializedName("stoNo")
    @Expose
    private Object stoNo;
    @SerializedName("itemId")
    @Expose
    private Object itemId;
    @SerializedName("itemName")
    @Expose
    private Object itemName;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("febrics")
    @Expose
    private Object febrics;
    @SerializedName("dia")
    @Expose
    private Object dia;
    @SerializedName("gsm")
    @Expose
    private Object gsm;
    @SerializedName("week")
    @Expose
    private Object week;
    @SerializedName("GQTY")
    @Expose
    private Object gQTY;
    @SerializedName("finishQTY")
    @Expose
    private Object finishQTY;
    @SerializedName("totalQTY")
    @Expose
    private Object totalQTY;
    @SerializedName("PSYRcvMtr")
    @Expose
    private Object pSYRcvMtr;
    @SerializedName("totalRoll")
    @Expose
    private Object totalRoll;
    @SerializedName("statusId")
    @Expose
    private Object statusId;
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
    private List<GrayFabricDetailsViewModel> grayFabricDetailsViewModels = null;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getMasterId() {
        return masterId;
    }

    public void setMasterId(Object masterId) {
        this.masterId = masterId;
    }

    public Object getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Object detailsId) {
        this.detailsId = detailsId;
    }

    public Object getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(Object buyerName) {
        this.buyerName = buyerName;
    }

    public Object getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Object orderNo) {
        this.orderNo = orderNo;
    }

    public Object getLotNo() {
        return lotNo;
    }

    public void setLotNo(Object lotNo) {
        this.lotNo = lotNo;
    }

    public Object getStoNo() {
        return stoNo;
    }

    public void setStoNo(Object stoNo) {
        this.stoNo = stoNo;
    }

    public Object getItemId() {
        return itemId;
    }

    public void setItemId(Object itemId) {
        this.itemId = itemId;
    }

    public Object getItemName() {
        return itemName;
    }

    public void setItemName(Object itemName) {
        this.itemName = itemName;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getFebrics() {
        return febrics;
    }

    public void setFebrics(Object febrics) {
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

    public Object getWeek() {
        return week;
    }

    public void setWeek(Object week) {
        this.week = week;
    }

    public Object getGQTY() {
        return gQTY;
    }

    public void setGQTY(Object gQTY) {
        this.gQTY = gQTY;
    }

    public Object getFinishQTY() {
        return finishQTY;
    }

    public void setFinishQTY(Object finishQTY) {
        this.finishQTY = finishQTY;
    }

    public Object getTotalQTY() {
        return totalQTY;
    }

    public void setTotalQTY(Object totalQTY) {
        this.totalQTY = totalQTY;
    }

    public Object getPSYRcvMtr() {
        return pSYRcvMtr;
    }

    public void setPSYRcvMtr(Object pSYRcvMtr) {
        this.pSYRcvMtr = pSYRcvMtr;
    }

    public Object getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Object totalRoll) {
        this.totalRoll = totalRoll;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(Object statusId) {
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

    public List<GrayFabricDetailsViewModel> getGrayFabricDetailsViewModels() {
        return grayFabricDetailsViewModels;
    }

    public void setGrayFabricDetailsViewModels(List<GrayFabricDetailsViewModel> grayFabricDetailsViewModels) {
        this.grayFabricDetailsViewModels = grayFabricDetailsViewModels;
    }

}
