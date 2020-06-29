
package com.opus_bd.stockmanagement.Model.GrayFabric.RackOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFabricIssueMaster {

    @SerializedName("issueNo")
    @Expose
    private String issueNo;
    @SerializedName("issueDate")
    @Expose
    private String issueDate;
    @SerializedName("issueBy")
    @Expose
    private String issueBy;
    @SerializedName("issueTo")
    @Expose
    private Object issueTo;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("isFinal")
    @Expose
    private Object isFinal;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("totalRoll")
    @Expose
    private Double totalRoll;
    @SerializedName("totalQTY")
    @Expose
    private Double totalQTY;
    @SerializedName("batchNo")
    @Expose
    private Object batchNo;
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

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public Object getIssueTo() {
        return issueTo;
    }

    public void setIssueTo(Object issueTo) {
        this.issueTo = issueTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Object getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Object isFinal) {
        this.isFinal = isFinal;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Double getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Double totalRoll) {
        this.totalRoll = totalRoll;
    }

    public Double getTotalQTY() {
        return totalQTY;
    }

    public void setTotalQTY(Double totalQTY) {
        this.totalQTY = totalQTY;
    }

    public Object getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Object batchNo) {
        this.batchNo = batchNo;
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
