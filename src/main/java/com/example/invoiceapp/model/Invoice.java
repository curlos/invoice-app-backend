package com.example.invoiceapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "payment_due", nullable = false)
    private String paymentDue;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_terms")
    private Integer paymentTerms;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "status")
    private String status;

    @Column(name = "sender_address", columnDefinition = "json")
    private String senderAddress;

    @Column(name = "client_address", columnDefinition = "json")
    private String clientAddress;

    @Column(name = "items")
    private List<Object> items;

    @Column(name = "total")
    private String total;


}