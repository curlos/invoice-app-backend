package com.example.invoiceapp.service;

import com.example.invoiceapp.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice saveInvoice(Invoice invoice);
    Invoice getInvoiceById(long id);
    Invoice updateInvoice(Invoice invoice, long id);
    void deleteInvoice(long id);
}
