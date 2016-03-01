/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yc.discountstrategy;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author ycheema
 */
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItem;
    private Date date = Calendar.getInstance().getTime();
    private double total;
    

    public Receipt(String custid,DatabaseStrategy db) {
        //Needs validation so that why we using set method
        setDb(db);
        setCustomer(db.findCustomrById(custid));
        //We make it zero array because we can add or delete later.
        lineItem = new LineItem[0];
    }
    public final void addItemToReceipt(String prodId, int qty){
        //Product product = db.findProductsById(prodId);
        //but we not need to do this because we use lineItem to add productsand it work 
        LineItem item = new LineItem(prodId,qty,db);
        addItemToArray(lineItem, item);
//        LineItem[] tempArray = new LineItem[lineItem.length + 1];
        //easy way to copy array rather than loop
//        System.arraycopy(lineItem,0,tempArray,0,lineItem.length);
//        tempArray[tempArray.length - 1] = item;
//        lineItem = tempArray;
        //We can hard code also with loop but that is long way.
        
    }
    private void addItemToArray(LineItem[] origArray, LineItem item){
         LineItem[] tempArray = new LineItem[origArray.length + 1];
          System.arraycopy(origArray,0,tempArray,0,origArray.length);
        tempArray[tempArray.length - 1] = item;
        lineItem = tempArray;
        
    }
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        //needs Validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        //Needs validation
        this.customer = customer;
    }

    public LineItem[] getLineItem() {
        return lineItem;
    }

    public final void setLineItem(LineItem[] lineItem) {
        this.lineItem = lineItem;
    }

    public final Date getDate() {
        return date;
    }

    public final void setDate(Date date) {
        this.date = date;
    }

    public final double getTotal() {
        return total;
    }

    public final void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
