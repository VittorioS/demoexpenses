package com.example.demo.entities.expense;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Expense {

    private @Id @GeneratedValue Long id;
    private String account;
    private String category;
    private Float amount;
    private String currency;
    private Date date;

    private Expense() {

    }

    /**
     * @param account
     * @param category
     * @param amount
     * @param currency
     * @param date
     */
    public Expense(String account, String category, Float amount, String currency, Date date) {
        this.account = account;
        this.category = category;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(account, amount, category, currency, date, id);
    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Expense other = (Expense) obj;
        return Objects.equals(account, other.account) && Objects.equals(amount, other.amount)
                && Objects.equals(category, other.category) && Objects.equals(currency, other.currency)
                && Objects.equals(date, other.date) && Objects.equals(id, other.id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Expense [account=" + account + ", amount=" + amount + ", category=" + category + ", currency="
                + currency + ", date=" + date + ", id=" + id + "]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
