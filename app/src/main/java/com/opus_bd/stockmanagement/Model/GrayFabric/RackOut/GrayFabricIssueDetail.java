
package com.opus_bd.stockmanagement.Model.GrayFabric.RackOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFabricIssueDetail {

    @SerializedName("issueMasterId")
    @Expose
    private Integer issueMasterId;
    @SerializedName("issueMaster")
    @Expose
    private IssueMaster issueMaster;
    @SerializedName("grayFebricsDetailId")
    @Expose
    private Integer grayFebricsDetailId;
    @SerializedName("grayFebricsDetail")
    @Expose
    private GrayFebricsDetail grayFebricsDetail;
    @SerializedName("stoNo")
    @Expose
    private Object stoNo;
    @SerializedName("totalRoll")
    @Expose
    private Object totalRoll;
    @SerializedName("issueQTY")
    @Expose
    private Object issueQTY;
    @SerializedName("issueQTYMtr")
    @Expose
    private Object issueQTYMtr;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
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

    public Integer getIssueMasterId() {
        return issueMasterId;
    }

    public void setIssueMasterId(Integer issueMasterId) {
        this.issueMasterId = issueMasterId;
    }

    public IssueMaster getIssueMaster() {
        return issueMaster;
    }

    public void setIssueMaster(IssueMaster issueMaster) {
        this.issueMaster = issueMaster;
    }

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

    public Object getStoNo() {
        return stoNo;
    }

    public void setStoNo(Object stoNo) {
        this.stoNo = stoNo;
    }

    public Object getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Object totalRoll) {
        this.totalRoll = totalRoll;
    }

    public Object getIssueQTY() {
        return issueQTY;
    }

    public void setIssueQTY(Object issueQTY) {
        this.issueQTY = issueQTY;
    }

    public Object getIssueQTYMtr() {
        return issueQTYMtr;
    }

    public void setIssueQTYMtr(Object issueQTYMtr) {
        this.issueQTYMtr = issueQTYMtr;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
