/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoon.invoicer.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.digitalplatoon.invoicer.Exception.InvoiceNotFoundException;
import za.co.digitalplatoon.invoicer.model.Invoice;
import za.co.digitalplatoon.invoicer.repository.InvoiceRepository;
import za.co.digitalplatoon.invoicer.repository.LineItemRepository;

/**
 *
 * @author CellC
 */
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    final InvoiceRepository invoiceRepository;
    final LineItemRepository lineItemRepository;

    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository, LineItemRepository lineItemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.lineItemRepository = lineItemRepository;
    }

    @PostMapping
    public ResponseEntity<?> addInvoice(@RequestBody Invoice invoiceBody) {

        Invoice invoice = invoiceRepository.save(invoiceBody);

        if (!invoice.getLineItems().isEmpty()) {
            invoice.getLineItems().stream().forEach(a -> {
                lineItemRepository.save(a);
            });
        }
        return ResponseEntity.ok(invoice);
    }

    @GetMapping
    public Collection<Invoice> viewAllInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/{invoiceID}")
    public Invoice viewInvoice(@PathVariable long invoiceID) {
        return invoiceRepository.findById(invoiceID).orElseThrow(() -> new InvoiceNotFoundException(invoiceID));
    }

}
