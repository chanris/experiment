package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

import java.math.BigDecimal;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description
 */
public class OrderInfo {
    private String productId;
    private String userId;
    private BigDecimal amount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
