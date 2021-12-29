package com.example.demo.entities.item;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    private @Id @GeneratedValue Long id;
    private String title;
    private Float amount;
    private String currency;
    private Date date;

    /*
     * Constructors
     */

    private Item() {
    }

    public Item(String title, Float amount, String currency, Date date) {
        this.title = title;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    /*
     * hashCode
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, title, amount, currency, date);
    }

    /*
     * Equals
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    /*
     * toString
     */

    @Override
    public String toString() {
        return "Item [amount=" + amount + ", currency=" + currency + ", date=" + date + ", id=" + id + ", title="
                + title + "]";
    }

    /*
     * Getters/Setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
