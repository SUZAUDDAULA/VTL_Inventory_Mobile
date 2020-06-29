
package com.opus_bd.stockmanagement.Model.GrayFabric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Roll {

    @SerializedName("detailsId")
    @Expose
    private Integer detailsId;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }


}
