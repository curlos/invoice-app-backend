package com.example.invoiceapp.controller;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.model.Item;
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
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get all items from a specific invoice
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") long invoiceId) {
//        itemService.getAllItems();
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(invoiceId),HttpStatus.OK);
    }

    // Get all items from a specific invoice
    @GetMapping("/{id}/items")
    public ResponseEntity<List<Item>> getAllInvoiceItems(@PathVariable("id") long invoiceId) {
//        itemService.getAllItems();
        return new ResponseEntity<List<Item>>(itemService.getAllItems(invoiceId),HttpStatus.OK);
    }

    // Save a new item
    @PostMapping("/items")
    public ResponseEntity<Item> saveItem(@RequestBody Item item, Invoice invoice) {
        return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    // Save a new invoice
    @PostMapping
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        System.out.println(invoice);
        return new ResponseEntity<Invoice>(invoiceService.saveInvoice(invoice), HttpStatus.CREATED);
    }
}
