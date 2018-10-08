/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoon.invoicer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author CellC
 */
@Entity
@Table(name = "lineItem")
public class LineItem implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineItemID;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice")
    private BigDecimal unitPrice;
    @JsonIgnore
    @ManyToOne
    private Invoice invoice;

    public LineItem() {
    }

    public LineItem(Long quantity, String description, BigDecimal unitPrice, Invoice invoice) {
        this.quantity = quantity;
        this.description = description;
        this.unitPrice = unitPrice;
        this.invoice = invoice;
    }

    public Long getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(Long lineItemID) {
        this.lineItemID = lineItemID;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getLineItemTotal() {
        return null;
    }
}
