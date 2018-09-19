/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Payments generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`payments`")
@IdClass(PaymentsId.class)
public class Payments implements Serializable {

    private String checkNumber;
    private Integer customerNumber;
    private Date paymentDate;
    private BigDecimal amount;
    private Customers customers;

    @Id
    @Column(name = "`checkNumber`", nullable = false, length = 50)
    public String getCheckNumber() {
        return this.checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Id
    @Column(name = "`customerNumber`", nullable = false, scale = 0, precision = 10)
    public Integer getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Column(name = "`paymentDate`", nullable = false)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "`amount`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customerNumber`", referencedColumnName = "`customerNumber`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`payments_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        if(customers != null) {
            this.customerNumber = customers.getCustomerNumber();
        }

        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payments)) return false;
        final Payments payments = (Payments) o;
        return Objects.equals(getCheckNumber(), payments.getCheckNumber()) &&
                Objects.equals(getCustomerNumber(), payments.getCustomerNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCheckNumber(),
                getCustomerNumber());
    }
}