
package com.opus_bd.stockmanagement.Model.GrayFabric.StockIn;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFabricStorageList {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("receiveNo")
    @Expose
    private String receiveNo;
    @SerializedName("autoNo")
    @Expose
    private String autoNo;
    @SerializedName("receiveDate")
    @Expose
    private String receiveDate;
    @SerializedName("inspectionDate")
    @Expose
    private String inspectionDate;
    @SerializedName("receiveBy")
    @Expose
    private String receiveBy;
    @SerializedName("monthName")
    @Expose
    private String monthName;
    @SerializedName("statusId")
    @Expose
    private int statusId;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("isFinal")
    @Expose
    private Object isFinal;
    @SerializedName("grayFebricsMasters")
    @Expose
    private List<GrayFebricsMaster> grayFebricsMasters = null;
    @SerializedName("reveivedGrayFabrics")
    @Expose
    private List<Object> reveivedGrayFabrics = null;
    @SerializedName("grayFebricsDetails")
    @Expose
    private Object grayFebricsDetails;
    @SerializedName("grayFebricsStorageMasters")
    @Expose
    private Object grayFebricsStorageMasters;
    @SerializedName("grayFabricRollViewModels")
    @Expose
    private Object grayFabricRollViewModels;
    @SerializedName("grayFabricRackingViewModels")
    @Expose
    private Object grayFabricRackingViewModels;
    @SerializedName("grayFebricsDetailViewModels")
    @Expose
    private Object grayFebricsDetailViewModels;
    @SerializedName("items")
    @Expose
    private Object items;
    @SerializedName("grayFabricIssueMasters")
    @Expose
    private Object grayFabricIssueMasters;
    @SerializedName("grayFabricIssueSuccessMasters")
    @Expose
    private Object grayFabricIssueSuccessMasters;
    @SerializedName("grayFebricsMaster")
    @Expose
    private Object grayFebricsMaster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    public String getAutoNo() {
        return autoNo;
    }

    public void setAutoNo(String autoNo) {
        this.autoNo = autoNo;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

    public List<GrayFebricsMaster> getGrayFebricsMasters() {
        return grayFebricsMasters;
    }

    public void setGrayFebricsMasters(List<GrayFebricsMaster> grayFebricsMasters) {
        this.grayFebricsMasters = grayFebricsMasters;
    }

    public List<Object> getReveivedGrayFabrics() {
        return reveivedGrayFabrics;
    }

    public void setReveivedGrayFabrics(List<Object> reveivedGrayFabrics) {
        this.reveivedGrayFabrics = reveivedGrayFabrics;
    }

    public Object getGrayFebricsDetails() {
        return grayFebricsDetails;
    }

    public void setGrayFebricsDetails(Object grayFebricsDetails) {
        this.grayFebricsDetails = grayFebricsDetails;
    }

    public Object getGrayFebricsStorageMasters() {
        return grayFebricsStorageMasters;
    }

    public void setGrayFebricsStorageMasters(Object grayFebricsStorageMasters) {
        this.grayFebricsStorageMasters = grayFebricsStorageMasters;
    }

    public Object getGrayFabricRollViewModels() {
        return grayFabricRollViewModels;
    }

    public void setGrayFabricRollViewModels(Object grayFabricRollViewModels) {
        this.grayFabricRollViewModels = grayFabricRollViewModels;
    }

    public Object getGrayFabricRackingViewModels() {
        return grayFabricRackingViewModels;
    }

    public void setGrayFabricRackingViewModels(Object grayFabricRackingViewModels) {
        this.grayFabricRackingViewModels = grayFabricRackingViewModels;
    }

    public Object getGrayFebricsDetailViewModels() {
        return grayFebricsDetailViewModels;
    }

    public void setGrayFebricsDetailViewModels(Object grayFebricsDetailViewModels) {
        this.grayFebricsDetailViewModels = grayFebricsDetailViewModels;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public Object getGrayFabricIssueMasters() {
        return grayFabricIssueMasters;
    }

    public void setGrayFabricIssueMasters(Object grayFabricIssueMasters) {
        this.grayFabricIssueMasters = grayFabricIssueMasters;
    }

    public Object getGrayFabricIssueSuccessMasters() {
        return grayFabricIssueSuccessMasters;
    }

    public void setGrayFabricIssueSuccessMasters(Object grayFabricIssueSuccessMasters) {
        this.grayFabricIssueSuccessMasters = grayFabricIssueSuccessMasters;
    }

    public Object getGrayFebricsMaster() {
        return grayFebricsMaster;
    }

    public void setGrayFebricsMaster(Object grayFebricsMaster) {
        this.grayFebricsMaster = grayFebricsMaster;
    }

}
