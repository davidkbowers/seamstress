package com.bowerstechnologies.seamstress.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Date placed is mandatory")
    private Instant placedDate;

    @NotBlank(message = "Date promised is mandatory")
    private Instant promisedDate;

    @NotBlank(message = "Total price is mandatory")
    private BigDecimal totalPrice;

    private BigDecimal totalPaid;

    //private Client client;
    private Long clientId;

    public ClientOrder() {}

    public ClientOrder(String description, Instant placedDate, Instant promisedDate, BigDecimal totalPrice, BigDecimal totalPaid, Long clientId) {
        this.description = description;
        this.placedDate = placedDate;
        this.promisedDate = promisedDate;
        this.totalPrice = totalPrice;
        this.totalPaid = totalPaid;
        this.clientId = clientId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Instant placedDate) {
        this.placedDate = placedDate;
    }

    public Instant getPromisedDate() {
        return promisedDate;
    }

    public void setPromisedDate(Instant promisedDate) {
        this.promisedDate = promisedDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String toString() {
        return "ClientOrder{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", placedDate='" + getPlacedDate() + "'" +
            ", promisedDate='" + getPromisedDate() + "'" +
            ", totalPrice=" + getTotalPrice() +
            ", totalPaid=" + getTotalPaid() +
            "}";
    }
	
}
