
package com.opus_bd.stockmanagement.Model.GrayFabric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrayFabricDetailsViewModel {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("masterId")
    @Expose
    private Integer masterId;
    @SerializedName("detailsId")
    @Expose
    private Integer detailsId;
    @SerializedName("buyerName")
    @Expose
    private Object buyerName;
    @SerializedName("orderNo")
    @Expose
    private Object orderNo;
    @SerializedName("lotNo")
    @Expose
    private Object lotNo;
    @SerializedName("stoNo")
    @Expose
    private Object stoNo;
    @SerializedName("itemId")
    @Expose
    private Object itemId;
    @SerializedName("itemName")
    @Expose
    private Object itemName;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("febrics")
    @Expose
    private Object febrics;
    @SerializedName("dia")
    @Expose
    private Object dia;
    @SerializedName("gsm")
    @Expose
    private Object gsm;
    @SerializedName("week")
    @Expose
    private Object week;
    @SerializedName("mcDIA")
    @Expose
    private Object mcDIA;
    @SerializedName("GQTY")
    @Expose
    private Double gQTY;
    @SerializedName("finishQTY")
    @Expose
    private Object finishQTY;
    @SerializedName("yarnBrank")
    @Expose
    private Object yarnBrank;
    @SerializedName("yarnCount")
    @Expose
    private Object yarnCount;
    @SerializedName("UOM")
    @Expose
    private Object uOM;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("totalQTY")
    @Expose
    private Object totalQTY;
    @SerializedName("PSYRcvMtr")
    @Expose
    private Object pSYRcvMtr;
    @SerializedName("totalRoll")
    @Expose
    private Object totalRoll;
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("rollNo")
    @Expose
    private String rollNo;

    @SerializedName("qrCode")
    @Expose
    private String qrCode;
    @SerializedName("materialNo")
    @Expose
    private Object materialNo;
    @SerializedName("materialDescription")
    @Expose
    private Object materialDescription;
    @SerializedName("rollId")
    @Expose
    private Object rollId;
    @SerializedName("detailsIdArray")
    @Expose
    private Object detailsIdArray;
    @SerializedName("IdArray")
    @Expose
    private Object idArray;
    @SerializedName("statusIdArray")
    @Expose
    private Object statusIdArray;
    @SerializedName("rackId")
    @Expose
    private Integer rackId;
    @SerializedName("rackIdArray")
    @Expose
    private Object rackIdArray;
    @SerializedName("cellNo")
    @Expose
    private Object cellNo;
    @SerializedName("grayFabricDetailsViewModels")
    @Expose
    private Object grayFabricDetailsViewModels;
    @SerializedName("grayFebricsStorageMasters")
    @Expose
    private Object grayFebricsStorageMasters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Object getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(Object buyerName) {
        this.buyerName = buyerName;
    }

    public Object getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Object orderNo) {
        this.orderNo = orderNo;
    }

    public Object getLotNo() {
        return lotNo;
    }

    public void setLotNo(Object lotNo) {
        this.lotNo = lotNo;
    }

    public Object getStoNo() {
        return stoNo;
    }

    public void setStoNo(Object stoNo) {
        this.stoNo = stoNo;
    }

    public Object getItemId() {
        return itemId;
    }

    public void setItemId(Object itemId) {
        this.itemId = itemId;
    }

    public Object getItemName() {
        return itemName;
    }

    public void setItemName(Object itemName) {
        this.itemName = itemName;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getFebrics() {
        return febrics;
    }

    public void setFebrics(Object febrics) {
        this.febrics = febrics;
    }

    public Object getDia() {
        return dia;
    }

    public void setDia(Object dia) {
        this.dia = dia;
    }

    public Object getGsm() {
        return gsm;
    }

    public void setGsm(Object gsm) {
        this.gsm = gsm;
    }

    public Object getWeek() {
        return week;
    }

    public void setWeek(Object week) {
        this.week = week;
    }

    public Object getMcDIA() {
        return mcDIA;
    }

    public void setMcDIA(Object mcDIA) {
        this.mcDIA = mcDIA;
    }

    public Double getgQTY() {
        return gQTY;
    }

    public void setgQTY(Double gQTY) {
        this.gQTY = gQTY;
    }

    public Object getFinishQTY() {
        return finishQTY;
    }

    public void setFinishQTY(Object finishQTY) {
        this.finishQTY = finishQTY;
    }

    public Object getYarnBrank() {
        return yarnBrank;
    }

    public void setYarnBrank(Object yarnBrank) {
        this.yarnBrank = yarnBrank;
    }

    public Object getYarnCount() {
        return yarnCount;
    }

    public void setYarnCount(Object yarnCount) {
        this.yarnCount = yarnCount;
    }

    public Object getuOM() {
        return uOM;
    }

    public void setuOM(Object uOM) {
        this.uOM = uOM;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getTotalQTY() {
        return totalQTY;
    }

    public void setTotalQTY(Object totalQTY) {
        this.totalQTY = totalQTY;
    }

    public Object getpSYRcvMtr() {
        return pSYRcvMtr;
    }

    public void setpSYRcvMtr(Object pSYRcvMtr) {
        this.pSYRcvMtr = pSYRcvMtr;
    }

    public Object getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Object totalRoll) {
        this.totalRoll = totalRoll;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Object getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(Object materialNo) {
        this.materialNo = materialNo;
    }

    public Object getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(Object materialDescription) {
        this.materialDescription = materialDescription;
    }

    public Object getRollId() {
        return rollId;
    }

    public void setRollId(Object rollId) {
        this.rollId = rollId;
    }

    public Object getDetailsIdArray() {
        return detailsIdArray;
    }

    public void setDetailsIdArray(Object detailsIdArray) {
        this.detailsIdArray = detailsIdArray;
    }

    public Object getIdArray() {
        return idArray;
    }

    public void setIdArray(Object idArray) {
        this.idArray = idArray;
    }

    public Object getStatusIdArray() {
        return statusIdArray;
    }

    public void setStatusIdArray(Object statusIdArray) {
        this.statusIdArray = statusIdArray;
    }

    public Integer getRackId() {
        return rackId;
    }

    public void setRackId(Integer rackId) {
        this.rackId = rackId;
    }

    public Object getRackIdArray() {
        return rackIdArray;
    }

    public void setRackIdArray(Object rackIdArray) {
        this.rackIdArray = rackIdArray;
    }

    public Object getCellNo() {
        return cellNo;
    }

    public void setCellNo(Object cellNo) {
        this.cellNo = cellNo;
    }

    public Object getGrayFabricDetailsViewModels() {
        return grayFabricDetailsViewModels;
    }

    public void setGrayFabricDetailsViewModels(Object grayFabricDetailsViewModels) {
        this.grayFabricDetailsViewModels = grayFabricDetailsViewModels;
    }

    public Object getGrayFebricsStorageMasters() {
        return grayFebricsStorageMasters;
    }

    public void setGrayFebricsStorageMasters(Object grayFebricsStorageMasters) {
        this.grayFebricsStorageMasters = grayFebricsStorageMasters;
    }
}
