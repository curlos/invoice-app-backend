package com.example.invoiceapp.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="invoices")
@TypeDefs({
        @TypeDef(name = "json", typeClass= JsonStringType.class)
})
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "payment_due")
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

    @Type(type = "json")
    @Column(name = "sender_address", columnDefinition = "json")
    private Address senderAddress;

    @Type(type = "json")
    @Column(name = "client_address", columnDefinition = "json")
    private Address clientAddress;

    @Column(name = "total")
    private String total;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private List<Item> items;

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", paymentDue='" + paymentDue + '\'' +
                ", description='" + description + '\'' +
                ", paymentTerms=" + paymentTerms +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", status='" + status + '\'' +
                ", senderAddress=" + senderAddress +
                ", clientAddress=" + clientAddress +
                ", total='" + total + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}