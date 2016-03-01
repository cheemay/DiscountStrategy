/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yc.discountstrategy;

/**
 *
 * @author ycheema
 */
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(String prodId, int qty,DatabaseStrategy db) {
        
        this.qty = qty;
        setProduct(db.findProductsById(prodId));
    }
    public final double getTotalPrice(){
        return qty * product.getUnitCost();
        
    }
    public final double getTotalDiscount(){
        return product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
    }
    

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //Need validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        //Need validation
        if (qty == 0){
            System.out.println("Error:qty should be greater than zero");
        }
        this.qty = qty;
    }
    
    
    
}
