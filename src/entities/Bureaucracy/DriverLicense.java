/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Bureaucracy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lenfer
 */
public class DriverLicense implements Serializable {
    public enum Category { A1, A, B1, B, C1, C, D1, D, CD };
    private List<Category> categories = new ArrayList<>();
    
    private Date issued;
    private Date expires;

    public DriverLicense(final Date issued,
            final Date expires,
            final Category category) {
        this.issued = issued;
        this.expires = expires;
        categories.add(category);
    }
    
    public DriverLicense(final Date issued,
            final Date expires,
            final List<Category> categories) {
        this.issued = issued;
        this.expires = expires;
        this.categories = categories;
    }
    
    public final List<Category> getCategories() {
        return categories;
    }

    public final void setCategories(final List<Category> categories) {
        this.categories = categories;
    }

    public final Date getIssued() {
        return issued;
    }

    public final void setIssued(final Date issued) {
        this.issued = issued;
    }

    public final Date getExpires() {
        return expires;
    }

    public final void setExpires(final Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "DriverLicense{" + "categories=" + categories 
                + ", issued=" + issued + ", expires=" + expires + '}';
    }
    
}
