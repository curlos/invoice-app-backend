package com.example.invoiceapp.service.impl;

import com.example.invoiceapp.exception.ResourceNotFoundException;
import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.repository.InvoiceRepository;
import com.example.invoiceapp.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        super();
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAllInvoices() {

        return invoiceRepository.findAll();
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        System.out.println(invoice);
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "Id", id));
    }

    @Override
    public Invoice updateInvoice(Invoice invoice, long id) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "Id", id));

        existingInvoice.setPaymentDue(invoice.getPaymentDue());
        existingInvoice.setDescription(invoice.getDescription());
        existingInvoice.setPaymentTerms(invoice.getPaymentTerms());
        existingInvoice.setClientName(invoice.getClientName());
        existingInvoice.setClientEmail(invoice.getClientEmail());
        existingInvoice.setStatus(invoice.getStatus());
        existingInvoice.setSenderAddress(invoice.getSenderAddress());
        existingInvoice.setClientAddress(invoice.getClientAddress());
        existingInvoice.setTotal(invoice.getTotal());
        existingInvoice.setItems(invoice.getItems());

        // Save existing invoice to DB
        invoiceRepository.save(existingInvoice);
        return existingInvoice;
    }

    @Override
    public void deleteInvoice(long id) {

    }
}
