
package com.opus_bd.stockmanagement.Model.GrayFabric.Scan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayRollDetailInfo {

    @SerializedName("grayFebricsDetailId")
    @Expose
    private Integer grayFebricsDetailId;
    @SerializedName("grayFebricsDetail")
    @Expose
    private GrayFebricsDetail grayFebricsDetail;
    @SerializedName("grayFebricsStorageDetailId")
    @Expose
    private Integer grayFebricsStorageDetailId;
    @SerializedName("grayFebricsStorageDetail")
    @Expose
    private GrayFebricsStorageDetail grayFebricsStorageDetail;
    @SerializedName("QTY")
    @Expose
    private Double qTY;
    @SerializedName("QTYMtr")
    @Expose
    private Object qTYMtr;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("rollNo")
    @Expose
    private Object rollNo;
    @SerializedName("cellNo")
    @Expose
    private Object cellNo;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("isDelete")
    @Expose
    private Object isDelete;
    @SerializedName("createdAt")
    @Expose
    private Object createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Object updatedAt;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;

    public Integer getGrayFebricsDetailId() {
        return grayFebricsDetailId;
    }

    public void setGrayFebricsDetailId(Integer grayFebricsDetailId) {
        this.grayFebricsDetailId = grayFebricsDetailId;
    }

    public GrayFebricsDetail getGrayFebricsDetail() {
        return grayFebricsDetail;
    }

    public void setGrayFebricsDetail(GrayFebricsDetail grayFebricsDetail) {
        this.grayFebricsDetail = grayFebricsDetail;
    }

    public Integer getGrayFebricsStorageDetailId() {
        return grayFebricsStorageDetailId;
    }

    public void setGrayFebricsStorageDetailId(Integer grayFebricsStorageDetailId) {
        this.grayFebricsStorageDetailId = grayFebricsStorageDetailId;
    }

    public GrayFebricsStorageDetail getGrayFebricsStorageDetail() {
        return grayFebricsStorageDetail;
    }

    public void setGrayFebricsStorageDetail(GrayFebricsStorageDetail grayFebricsStorageDetail) {
        this.grayFebricsStorageDetail = grayFebricsStorageDetail;
    }

    public Double getQTY() {
        return qTY;
    }

    public void setQTY(Double qTY) {
        this.qTY = qTY;
    }

    public Object getQTYMtr() {
        return qTYMtr;
    }

    public void setQTYMtr(Object qTYMtr) {
        this.qTYMtr = qTYMtr;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Object getRollNo() {
        return rollNo;
    }

    public void setRollNo(Object rollNo) {
        this.rollNo = rollNo;
    }

    public Object getCellNo() {
        return cellNo;
    }

    public void setCellNo(Object cellNo) {
        this.cellNo = cellNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Object isDelete) {
        this.isDelete = isDelete;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

}
