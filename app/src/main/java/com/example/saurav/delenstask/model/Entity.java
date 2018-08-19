package com.example.saurav.delenstask.model;

import java.io.Serializable;

public class Entity implements Serializable {
    String id;
    String adress;
    String delivered_date;
    String status;
    String job_type;
    String person_assigned;
    String rate;
    String tax;
    String discount;
    String start_time;
    String end_time;
    String payment_status;
    String services_for;
    String service_place;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDelivered_date() {
        return delivered_date;
    }

    public void setDelivered_date(String delivered_date) {
        this.delivered_date = delivered_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getPerson_assigned() {
        return person_assigned;
    }

    public void setPerson_assigned(String person_assigned) {
        this.person_assigned = person_assigned;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getServices_for() {
        return services_for;
    }

    public void setServices_for(String services_for) {
        this.services_for = services_for;
    }

    public String getService_place() {
        return service_place;
    }

    public void setService_place(String service_place) {
        this.service_place = service_place;
    }
}
