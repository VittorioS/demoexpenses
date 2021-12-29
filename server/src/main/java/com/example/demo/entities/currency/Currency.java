package com.example.demo.entities.currency;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Currency {

    private @Id @GeneratedValue Long id;
    private String symbols;
    private String code;
    private String number;
    private Integer decimals;

    private Currency() {

    }

    /**
     * @param symbols
     * @param code
     * @param number
     * @param decimals
     */
    public Currency(String symbols, String code, String number, Integer decimals) {
        this.symbols = symbols;
        this.code = code;
        this.number = number;
        this.decimals = decimals;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(code, decimals, id, number, symbols);
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
        Currency other = (Currency) obj;
        return Objects.equals(code, other.code) && Objects.equals(decimals, other.decimals)
                && Objects.equals(id, other.id) && Objects.equals(number, other.number)
                && Objects.equals(symbols, other.symbols);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Currency [code=" + code + ", decimals=" + decimals + ", id=" + id + ", number=" + number + ", symbols="
                + symbols + "]";
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
     * @return the symbols
     */
    public String getSymbols() {
        return symbols;
    }

    /**
     * @param symbols the symbols to set
     */
    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the decimals
     */
    public Integer getDecimals() {
        return decimals;
    }

    /**
     * @param decimals the decimals to set
     */
    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

}
