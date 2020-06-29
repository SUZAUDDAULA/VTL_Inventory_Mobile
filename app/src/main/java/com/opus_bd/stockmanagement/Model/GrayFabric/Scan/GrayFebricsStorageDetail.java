
package com.opus_bd.stockmanagement.Model.GrayFabric.Scan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFebricsStorageDetail {

    @SerializedName("febricsStorageMasterId")
    @Expose
    private Integer febricsStorageMasterId;
    @SerializedName("grayFebricsStorageMaster")
    @Expose
    private Object grayFebricsStorageMaster;
    @SerializedName("cellNo")
    @Expose
    private String cellNo;
    @SerializedName("xAxis")
    @Expose
    private Integer xAxis;
    @SerializedName("yAxis")
    @Expose
    private Integer yAxis;
    @SerializedName("drowerNo")
    @Expose
    private Object drowerNo;
    @SerializedName("boxNo")
    @Expose
    private Object boxNo;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("qrCode")
    @Expose
    private String qrCode;
    @SerializedName("maxCapacity")
    @Expose
    private Object maxCapacity;
    @SerializedName("existingQTY")
    @Expose
    private Object existingQTY;
    @SerializedName("totalRoll")
    @Expose
    private Object totalRoll;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("isDelete")
    @Expose
    private Object isDelete;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Object updatedAt;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;

    public Integer getFebricsStorageMasterId() {
        return febricsStorageMasterId;
    }

    public void setFebricsStorageMasterId(Integer febricsStorageMasterId) {
        this.febricsStorageMasterId = febricsStorageMasterId;
    }

    public Object getGrayFebricsStorageMaster() {
        return grayFebricsStorageMaster;
    }

    public void setGrayFebricsStorageMaster(Object grayFebricsStorageMaster) {
        this.grayFebricsStorageMaster = grayFebricsStorageMaster;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public Integer getXAxis() {
        return xAxis;
    }

    public void setXAxis(Integer xAxis) {
        this.xAxis = xAxis;
    }

    public Integer getYAxis() {
        return yAxis;
    }

    public void setYAxis(Integer yAxis) {
        this.yAxis = yAxis;
    }

    public Object getDrowerNo() {
        return drowerNo;
    }

    public void setDrowerNo(Object drowerNo) {
        this.drowerNo = drowerNo;
    }

    public Object getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(Object boxNo) {
        this.boxNo = boxNo;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Object getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Object maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Object getExistingQTY() {
        return existingQTY;
    }

    public void setExistingQTY(Object existingQTY) {
        this.existingQTY = existingQTY;
    }

    public Object getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Object totalRoll) {
        this.totalRoll = totalRoll;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

}
