package pl.coderslab.model;

import java.time.LocalDateTime;

/**
 *
 * @author Tomek
 */
public class Order {
    
    private LocalDateTime orderAcceptanceDate;
    private LocalDateTime plannedRepairStartDate;
    private LocalDateTime repairStartDate;
    private Employee orderEmployee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private double orderCost;
    private double partsCost;
    private double workhourCost;
    private int workhours;
    private int clientId;
    private int vehicleId;
    private int employeeId;

    public Order(LocalDateTime orderAcceptanceDate, LocalDateTime plannedRepairStartDate, LocalDateTime repairStartDate, Employee orderEmployee, String problemDescription, String repairDescription, Status status, Vehicle vehicle, double orderCost, double partsCost, double workhourCost, int workhours) {
        this.orderAcceptanceDate = orderAcceptanceDate;
        this.plannedRepairStartDate = plannedRepairStartDate;
        this.repairStartDate = repairStartDate;
        this.orderEmployee = orderEmployee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.orderCost = orderCost;
        this.partsCost = partsCost;
        this.workhourCost = workhourCost;
        this.workhours = workhours;
    }

    public LocalDateTime getOrderAcceptanceDate() {
        return orderAcceptanceDate;
    }

    public void setOrderAcceptanceDate(LocalDateTime orderAcceptanceDate) {
        this.orderAcceptanceDate = orderAcceptanceDate;
    }

    public LocalDateTime getPlannedRepairStartDate() {
        return plannedRepairStartDate;
    }

    public void setPlannedRepairStartDate(LocalDateTime plannedRepairStartDate) {
        this.plannedRepairStartDate = plannedRepairStartDate;
    }

    public LocalDateTime getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(LocalDateTime repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public Employee getOrderEmployee() {
        return orderEmployee;
    }

    public void setOrderEmployee(Employee orderEmployee) {
        this.orderEmployee = orderEmployee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getWorkhourCost() {
        return workhourCost;
    }

    public void setWorkhourCost(double workhourCost) {
        this.workhourCost = workhourCost;
    }

    public int getWorkhours() {
        return workhours;
    }

    public void setWorkhours(int workhours) {
        this.workhours = workhours;
    }

    @Override
    public String toString() {
        return "Order{" + "orderAcceptanceDate=" + orderAcceptanceDate + ", plannedRepairStartDate=" + plannedRepairStartDate + ", repairStartDate=" + repairStartDate + ", orderEmployee=" + orderEmployee + ", problemDescription=" + problemDescription + ", repairDescription=" + repairDescription + ", status=" + status + ", vehicle=" + vehicle + ", orderCost=" + orderCost + ", partsCost=" + partsCost + ", workhourCost=" + workhourCost + ", workhours=" + workhours + '}';
    }
}
