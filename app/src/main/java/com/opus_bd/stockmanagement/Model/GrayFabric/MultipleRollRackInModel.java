
package com.opus_bd.stockmanagement.Model.GrayFabric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleRollRackInModel {

    @SerializedName("qrCode")
    @Expose
    private String qrCode;
    @SerializedName("rolls")
    @Expose
    private List<Roll> rolls = null;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

}
