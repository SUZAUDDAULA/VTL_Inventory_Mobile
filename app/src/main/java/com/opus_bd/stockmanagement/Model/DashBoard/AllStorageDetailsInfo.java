
package com.opus_bd.stockmanagement.Model.DashBoard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllStorageDetailsInfo {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("rackId")
    @Expose
    private Integer rackId;
    @SerializedName("cellNo")
    @Expose
    private String cellNo;
    @SerializedName("receiveNo")
    @Expose
    private Object receiveNo;
    @SerializedName("rackNumber")
    @Expose
    private String rackNumber;
    @SerializedName("QTY")
    @Expose
    private Double qTY;
    @SerializedName("xAxis")
    @Expose
    private Integer xAxis;
    @SerializedName("yAxis")
    @Expose
    private Integer yAxis;
    @SerializedName("febricsStorageId")
    @Expose
    private Object febricsStorageId;
    @SerializedName("statusId")
    @Expose
    private Object statusId;
    @SerializedName("maxCapacity")
    @Expose
    private Double maxCapacity;
    @SerializedName("usedQTY")
    @Expose
    private Object usedQTY;
    @SerializedName("existingQTY")
    @Expose
    private Double existingQTY;
    @SerializedName("finishFabricCurrentStorageViewModel")
    @Expose
    private Object finishFabricCurrentStorageViewModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRackId() {
        return rackId;
    }

    public void setRackId(Integer rackId) {
        this.rackId = rackId;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public Object getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(Object receiveNo) {
        this.receiveNo = receiveNo;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public Double getQTY() {
        return qTY;
    }

    public void setQTY(Double qTY) {
        this.qTY = qTY;
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

    public Object getFebricsStorageId() {
        return febricsStorageId;
    }

    public void setFebricsStorageId(Object febricsStorageId) {
        this.febricsStorageId = febricsStorageId;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(Object statusId) {
        this.statusId = statusId;
    }

    public Double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Object getUsedQTY() {
        return usedQTY;
    }

    public void setUsedQTY(Object usedQTY) {
        this.usedQTY = usedQTY;
    }

    public Double getExistingQTY() {
        return existingQTY;
    }

    public void setExistingQTY(Double existingQTY) {
        this.existingQTY = existingQTY;
    }

    public Object getFinishFabricCurrentStorageViewModel() {
        return finishFabricCurrentStorageViewModel;
    }

    public void setFinishFabricCurrentStorageViewModel(Object finishFabricCurrentStorageViewModel) {
        this.finishFabricCurrentStorageViewModel = finishFabricCurrentStorageViewModel;
    }

}
