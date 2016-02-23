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
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;

    public Receipt(String custid,DatabaseStrategy db) {
        //Needs validation so that why we using set method
        setDb(db);
        setCustomer(db.findCustomrById(custid));
    }
    

    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        //needs Validation
        this.db = db;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        //Needs validation
        this.customer = customer;
    }
    
    
}
