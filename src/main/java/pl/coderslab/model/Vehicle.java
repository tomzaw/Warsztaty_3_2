package pl.coderslab.model;

import java.time.LocalDate;

/**
 *
 * @author Tomek
 */
public class Vehicle {
    
    private String model;
    private String producent;
    private LocalDate productionDate;
    private String registration;
    private LocalDate nextReviewDate;
    private int clientId;

    public Vehicle(String model, String producent, LocalDate productionDate, String registration, LocalDate nextReviewDate) {
        this.model = model;
        this.producent = producent;
        this.productionDate = productionDate;
        this.registration = registration;
        this.nextReviewDate = nextReviewDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDate getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(LocalDate nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model=" + model + ", producent=" + producent + ", productionDate=" + productionDate + ", registration=" + registration + ", nextReviewDate=" + nextReviewDate + '}';
    }
}
