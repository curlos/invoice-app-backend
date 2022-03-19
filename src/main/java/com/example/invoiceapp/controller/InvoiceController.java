package com.example.invoiceapp.controller;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.service.InvoiceService;
import com.example.invoiceapp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final ItemService itemService;

    public InvoiceController(InvoiceService invoiceService, ItemService itemService) {
        super();
        this.invoiceService = invoiceService;
        this.itemService = itemService;
    }

    // Get all invoices
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Save a new invoice
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        System.out.println(invoice);
        return new ResponseEntity<Invoice>(invoiceService.saveInvoice(invoice), HttpStatus.CREATED);
    }

    // Get all invoices
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("{id}")
    public Invoice getInvoiceById(@PathVariable("id") long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Update invoice
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("{id}")
    public ResponseEntity<Invoice> updateEmployee(@PathVariable("id") long id, @RequestBody Invoice invoice){
        return new ResponseEntity<Invoice>(invoiceService.updateInvoice(invoice, id), HttpStatus.OK);
    }

    // Delete invoice
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        // delete invoice from DB
        invoiceService.deleteInvoice(id);

        return new ResponseEntity<String>("Invoice deleted successfully!.", HttpStatus.OK);
    }

}
