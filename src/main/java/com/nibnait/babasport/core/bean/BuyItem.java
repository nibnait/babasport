package com.nibnait.babasport.core.bean;

import com.nibnait.babasport.core.bean.product.Sku;

import java.util.Objects;

/**
 * 购物项
 * Created by nibnait on 2016/5/9.
 */
public class BuyItem {

    private Sku sku;
    private int amount = 1;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyItem other = (BuyItem) obj;
        if (sku == null) {
            if (other.sku != null)
                return false;
        } else if (!sku.getId().equals(other.sku.getId()))
            return false;
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BuyItem buyItem = (BuyItem) o;
//        return getAmount() == buyItem.getAmount() &&
//                Objects.equals(getSku().getId(), buyItem.getSku().getId());//此处也不应该比地址，比的是skuId
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getSku(), getAmount());
//    }
}
