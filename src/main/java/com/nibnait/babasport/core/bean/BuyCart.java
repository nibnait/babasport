package com.nibnait.babasport.core.bean;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * Created by nibnait on 2016/5/9.
 */
public class BuyCart {

    private List<BuyItem> items = new ArrayList<BuyItem>();
    //继续购物时  最后一款商品的ID
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<BuyItem> getItems() {
        return items;
    }

    public void setItems(List<BuyItem> items) {
        this.items = items;
    }

    public void subItem(BuyItem buyItem){

        //判断是否重复
        if (items.contains(buyItem)){

            for (BuyItem item:items){
                if (item.equals(buyItem)){  //比的是他俩的skuId
                    //buyItem.getAmount() == -1
                    int result = item.getAmount()-1;
                    if (result>0){
                        item.setAmount(result);
                    }else {
                        deleteItem(buyItem);
                    }
                }
            }
        }else {
            this.items.add(buyItem);
        }
    }

    public void addItem(BuyItem buyItem){

        //判断是否重复
        if (items.contains(buyItem)){

            for (BuyItem item:items){
                if (item.equals(buyItem)){  //比的是他俩的skuId
                    int result = buyItem.getAmount()+item.getAmount() ;
                    int buyLimit = item.getSku().getSkuUpperLimit();
                    //购买限制
                    if (result<=buyLimit){
                        item.setAmount(result);
                    }else {
                        item.setAmount(buyLimit);
                    }
                }
            }
        }else {
            this.items.add(buyItem);
        }
    }

    //小计
    //商品数量
    @JsonIgnore
    public int getProductAmount(){
        int result = 0;
        for(BuyItem item : items){
            result += item.getAmount();
        }
        return result;
    }
    //商品金额
    @JsonIgnore
    public Double getProductPrice(){
        Double result = 0.00;
        for(BuyItem item : items){
            result += item.getSku().getSkuPrice()*item.getAmount();
        }
        return result;
    }
    //运费
    @JsonIgnore
    public Double getFee(){
        Double result = 0.00;
        if(getProductPrice() <= 39){
            result = 10.00;
        }
        return result;
    }
    //应付金额
    @JsonIgnore
    public Double getTotalPrice(){
        return getFee() + getProductPrice();
    }


    //删除一个
    public void deleteItem(BuyItem item){
        items.remove(item);
    }


}
