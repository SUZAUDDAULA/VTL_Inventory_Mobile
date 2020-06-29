
package com.opus_bd.stockmanagement.Model.GrayFabric.RackIn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFebricsStorageMaster {

    @SerializedName("rackNumber")
    @Expose
    private String rackNumber;
    @SerializedName("MaxCapacity")
    @Expose
    private Double maxCapacity;
    @SerializedName("xAxis")
    @Expose
    private Integer xAxis;
    @SerializedName("yAxis")
    @Expose
    private Integer yAxis;
    @SerializedName("rollCapacity")
    @Expose
    private Double rollCapacity;
    @SerializedName("unitId")
    @Expose
    private Object unitId;
    @SerializedName("unit")
    @Expose
    private Object unit;
    @SerializedName("qrCode")
    @Expose
    private Object qrCode;
    @SerializedName("remarks")
    @Expose
    private Object remarks;
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

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public Double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {
        this.maxCapacity = maxCapacity;
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

    public Double getRollCapacity() {
        return rollCapacity;
    }

    public void setRollCapacity(Double rollCapacity) {
        this.rollCapacity = rollCapacity;
    }

    public Object getUnitId() {
        return unitId;
    }

    public void setUnitId(Object unitId) {
        this.unitId = unitId;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public Object getQrCode() {
        return qrCode;
    }

    public void setQrCode(Object qrCode) {
        this.qrCode = qrCode;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
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
