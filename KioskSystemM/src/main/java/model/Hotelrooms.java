package model;

import jakarta.persistence.*;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity

public class Hotelrooms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_number")
    private int roomNumber;
    @Basic
    @Column(name = "room_type")
    private String roomType;
    @Basic
    @Column(name = "room_capacity")
    private int roomCapacity;
    @Basic
    @Column(name = "room_rate")
    private double roomRate;
    @Basic
    @Column(name = "check_in")
    private Date checkIn;
    @Basic
    @Column(name = "check_out")
    private Date checkOut;
    @Basic
    @Column(name = "isAvailable")
    private boolean isAvailable;
    @Basic
    @Column(name = "tax")
    private BigDecimal tax;




    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(double roomRate) {
        this.roomRate = roomRate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(java.sql.Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(java.sql.Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = BigDecimal.valueOf(tax);
    }

    public void setTax(Double tax) {
        this.tax = BigDecimal.valueOf(tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotelrooms that = (Hotelrooms) o;
        return roomNumber == that.roomNumber && roomCapacity == that.roomCapacity && Double.compare(that.roomRate, roomRate) == 0 && isAvailable == that.isAvailable && Objects.equals(roomType, that.roomType) && Objects.equals(checkIn, that.checkIn) && Objects.equals(checkOut, that.checkOut) && Objects.equals(tax, that.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, roomCapacity, roomRate, checkIn, checkOut, isAvailable, tax);
    }


    //_------------HQL Session------------------
    public static int CheckOut(int roomNumber) {
        System.out.println("in CheckOut() ...");
        int flag = 1;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Please wait while we get you checked out!");
        Reservations.DeleteReservation(roomNumber);

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hotelrooms.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve room based on the id: primary key
            System.out.println("\nGetting room with id: " + roomNumber);

            Hotelrooms room = (Hotelrooms) session.get(Hotelrooms.class, roomNumber);

            if (room == null) {
                return -1;
            } else {
                if (room.isAvailable == true) {
                    flag = 0;
                }
                System.out.println("Updating Room...");
                room.setIsAvailable(true);
                room.setCheckOut(new Date());
            }
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("CheckOut Done!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            factory.close();
        }
        return flag;
    }

}
