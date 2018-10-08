/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoon.invoicer.Exception;

/**
 *
 * @author CellC
 */
public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(Long invoiceID) {
        super("data for invoice " + invoiceID + " not found.");
    }

}
