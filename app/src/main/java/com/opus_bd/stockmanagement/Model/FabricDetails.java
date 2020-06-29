
package com.opus_bd.stockmanagement.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FabricDetails {

    @SerializedName("receiveNo")
    @Expose
    private Object receiveNo;
    @SerializedName("receiveDate")
    @Expose
    private Object receiveDate;
    @SerializedName("inspectionDate")
    @Expose
    private Object inspectionDate;
    @SerializedName("receiveBy")
    @Expose
    private Object receiveBy;
    @SerializedName("monthName")
    @Expose
    private Object monthName;
    @SerializedName("statusId")
    @Expose
    private Object statusId;
    @SerializedName("remarks")
    @Expose
    private Object remarks;
    @SerializedName("finishFebricsMasters")
    @Expose
    private List<FinishFebricsMaster> finishFebricsMasters = null;
    @SerializedName("reveivedFinishFabrics")
    @Expose
    private List<ReveivedFinishFabric> reveivedFinishFabrics = null;
    @SerializedName("finishFebricsDetails")
    @Expose
    private Object finishFebricsDetails;
    @SerializedName("finishFebricsStorageMasters")
    @Expose
    private Object finishFebricsStorageMasters;
    @SerializedName("fabricRackingViewModels")
    @Expose
    private Object fabricRackingViewModels;
    @SerializedName("febricsDetailViewModels")
    @Expose
    private Object febricsDetailViewModels;
    @SerializedName("items")
    @Expose
    private Object items;
    @SerializedName("finishFebricMaster")
    @Expose
    private Object finishFebricMaster;

    public Object getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(Object receiveNo) {
        this.receiveNo = receiveNo;
    }

    public Object getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Object receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Object getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Object inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Object getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(Object receiveBy) {
        this.receiveBy = receiveBy;
    }

    public Object getMonthName() {
        return monthName;
    }

    public void setMonthName(Object monthName) {
        this.monthName = monthName;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(Object statusId) {
        this.statusId = statusId;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }

    public List<FinishFebricsMaster> getFinishFebricsMasters() {
        return finishFebricsMasters;
    }

    public void setFinishFebricsMasters(List<FinishFebricsMaster> finishFebricsMasters) {
        this.finishFebricsMasters = finishFebricsMasters;
    }

    public List<ReveivedFinishFabric> getReveivedFinishFabrics() {
        return reveivedFinishFabrics;
    }

    public void setReveivedFinishFabrics(List<ReveivedFinishFabric> reveivedFinishFabrics) {
        this.reveivedFinishFabrics = reveivedFinishFabrics;
    }

    public Object getFinishFebricsDetails() {
        return finishFebricsDetails;
    }

    public void setFinishFebricsDetails(Object finishFebricsDetails) {
        this.finishFebricsDetails = finishFebricsDetails;
    }

    public Object getFinishFebricsStorageMasters() {
        return finishFebricsStorageMasters;
    }

    public void setFinishFebricsStorageMasters(Object finishFebricsStorageMasters) {
        this.finishFebricsStorageMasters = finishFebricsStorageMasters;
    }

    public Object getFabricRackingViewModels() {
        return fabricRackingViewModels;
    }

    public void setFabricRackingViewModels(Object fabricRackingViewModels) {
        this.fabricRackingViewModels = fabricRackingViewModels;
    }

    public Object getFebricsDetailViewModels() {
        return febricsDetailViewModels;
    }

    public void setFebricsDetailViewModels(Object febricsDetailViewModels) {
        this.febricsDetailViewModels = febricsDetailViewModels;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public Object getFinishFebricMaster() {
        return finishFebricMaster;
    }

    public void setFinishFebricMaster(Object finishFebricMaster) {
        this.finishFebricMaster = finishFebricMaster;
    }

}
