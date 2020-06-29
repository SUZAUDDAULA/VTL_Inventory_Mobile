package com.opus_bd.stockmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinishFabricStorageByRecevedNo {
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
    private String receiveNo;
    @SerializedName("QTY")
    @Expose
    private Double qTY;
    @SerializedName("febricsStorageId")
    @Expose
    private Object febricsStorageId;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;

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

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    public Double getQTY() {
        return qTY;
    }

    public void setQTY(Double qTY) {
        this.qTY = qTY;
    }

    public Object getFebricsStorageId() {
        return febricsStorageId;
    }

    public void setFebricsStorageId(Object febricsStorageId) {
        this.febricsStorageId = febricsStorageId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }


}
