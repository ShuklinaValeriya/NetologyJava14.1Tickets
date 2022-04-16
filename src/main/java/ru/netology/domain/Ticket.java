package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {


    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    public Ticket() {
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return price;
    }

    public void setCost(int cost) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void from(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public boolean matches(String text) {
        if (getFrom().contains(text)) {
            return true;
        }
        if (getTo().contains(text)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && travelTime == ticket.travelTime && from.equals(ticket.from) && to.equals(ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, travelTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", costTicket=" + price +
                ", departureAirport='" + from + '\'' +
                ", arrivalAirport='" + to + '\'' +
                ", timeTravel=" + travelTime +
                '}';
    }

    @Override
    public int compareTo(Ticket ticket) {
        return this.price - ticket.price;
    }

}