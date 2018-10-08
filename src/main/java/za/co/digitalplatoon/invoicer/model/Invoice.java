/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoon.invoicer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
#spring.h2.console.path=/h2_console
#spring.h2.console.port=8080
#spring.datasource.url=jdbc:h2:mem:~/h2/invoiceDB
#spring.datasource.url=jdbc:h2:mem:invoiceDB
#spring.datasource.username=sa
#spring.datasource.password=
#spring.datasource.driverClassName=org.h2.Driver
#spring.jpa.hibernate.ddl-auto=create
#spring.jpa.show-sql=true
 * @author CellC
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceID;
    @Column(name = "client")
    private String client;
    @Column(name = "vatRate")
    private long vatRate;
    @Column(name = "invoiceDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDate;
    @OneToMany(mappedBy = "invoice")
    private Set<LineItem> lineItems = new HashSet<>();

    public Invoice() {
    }

    public Long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getSubTotal() {

        return null;
    }

    public BigDecimal getVat() {

        return null;
    }

    public BigDecimal getTotal() {

        return null;
    }

}
