
package com.opus_bd.stockmanagement.Model.GrayFabric.RackOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RackoutById {

    @SerializedName("issueNo")
    @Expose
    private Object issueNo;
    @SerializedName("issueDate")
    @Expose
    private Object issueDate;
    @SerializedName("issueBy")
    @Expose
    private Object issueBy;
    @SerializedName("remarks")
    @Expose
    private Object remarks;
    @SerializedName("isFinal")
    @Expose
    private Object isFinal;
    @SerializedName("batchNo")
    @Expose
    private Object batchNo;
    @SerializedName("grayFabricIssueDetailViewModels")
    @Expose
    private Object grayFabricIssueDetailViewModels;
    @SerializedName("grayFabricIssueDetails")
    @Expose
    private List<GrayFabricIssueDetail> grayFabricIssueDetails = null;
    @SerializedName("detailsIdArray")
    @Expose
    private Object detailsIdArray;

    public Object getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(Object issueNo) {
        this.issueNo = issueNo;
    }

    public Object getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Object issueDate) {
        this.issueDate = issueDate;
    }

    public Object getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(Object issueBy) {
        this.issueBy = issueBy;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    public Object getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Object isFinal) {
        this.isFinal = isFinal;
    }

    public Object getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Object batchNo) {
        this.batchNo = batchNo;
    }

    public Object getGrayFabricIssueDetailViewModels() {
        return grayFabricIssueDetailViewModels;
    }

    public void setGrayFabricIssueDetailViewModels(Object grayFabricIssueDetailViewModels) {
        this.grayFabricIssueDetailViewModels = grayFabricIssueDetailViewModels;
    }

    public List<GrayFabricIssueDetail> getGrayFabricIssueDetails() {
        return grayFabricIssueDetails;
    }

    public void setGrayFabricIssueDetails(List<GrayFabricIssueDetail> grayFabricIssueDetails) {
        this.grayFabricIssueDetails = grayFabricIssueDetails;
    }

    public Object getDetailsIdArray() {
        return detailsIdArray;
    }

    public void setDetailsIdArray(Object detailsIdArray) {
        this.detailsIdArray = detailsIdArray;
    }

}
