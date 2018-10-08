/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoon.invoicer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.digitalplatoon.invoicer.model.Invoice;

/**
 *
 * @author CellC
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    
}
