package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;


@jakarta.persistence.Entity
@Entity
public class Reservations {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_id")
    @jakarta.persistence.Column(name = "reservation_id")
    private String reservationId;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "total_room_charge")
    @jakarta.persistence.Column(name = "total_room_charge")
    private Double totalRoomCharge;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "guest_name")
    @jakarta.persistence.Column(name = "guest_name")
    private String guestName;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "verify_id")
    @jakarta.persistence.Column(name = "verify_id")
    private static String verifyId;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "check_in")
    @jakarta.persistence.Column(name = "check_in")
    private Date checkIn;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "check_out")
    @jakarta.persistence.Column(name = "check_out")
    private Date checkOut;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "total_guest")
    @jakarta.persistence.Column(name = "total_guest")
    private int totalGuest;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "num_of_nights")
    @jakarta.persistence.Column(name = "num_of_nights")
    private int numOfNights;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "room_type")
    @jakarta.persistence.Column(name = "room_type")
    private String roomType;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "nightly_rate")
    @jakarta.persistence.Column(name = "nightly_rate")
    private double nightlyRate;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "stay_summary")
    @jakarta.persistence.Column(name = "stay_summary")
    private double staySummary;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "credit_card")
    @jakarta.persistence.Column(name = "credit_card")
    private int creditCard;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "room_number")
    @jakarta.persistence.Column(name = "room_number")
    private int roomNumber;
    @jakarta.persistence.Basic
    @Basic
    @Column(name = "qr_code")
    @jakarta.persistence.Column(name = "qr_code")
    private byte[] qrCode;
    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "isQrActivated")
    private boolean isQrActivated;


    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Double getTotalRoomCharge() {
        return totalRoomCharge;
    }

    public void setTotalRoomCharge(Double totalRoomCharge) {
        this.totalRoomCharge = totalRoomCharge;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(String verifyId) {
        this.verifyId = verifyId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(int totalGuest) {
        this.totalGuest = totalGuest;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(double nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public double getStaySummary() {
        return staySummary;
    }

    public void setStaySummary(double staySummary) {
        this.staySummary = staySummary;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations that = (Reservations) o;
        return totalGuest == that.totalGuest && numOfNights == that.numOfNights && Double.compare(that.nightlyRate, nightlyRate) == 0 && Double.compare(that.staySummary, staySummary) == 0 && creditCard == that.creditCard && roomNumber == that.roomNumber && Objects.equals(reservationId, that.reservationId) && Objects.equals(totalRoomCharge, that.totalRoomCharge) && Objects.equals(guestName, that.guestName) && Objects.equals(verifyId, that.verifyId) && Objects.equals(checkIn, that.checkIn) && Objects.equals(checkOut, that.checkOut) && Objects.equals(roomType, that.roomType) && Arrays.equals(qrCode, that.qrCode);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(reservationId, totalRoomCharge, guestName, verifyId, checkIn, checkOut, totalGuest, numOfNights, roomType, nightlyRate, staySummary, creditCard, roomNumber);
        result = 31 * result + Arrays.hashCode(qrCode);
        return result;
    }

    public boolean isQrActivated() {
        return isQrActivated;
    }

    public void setQrActivated(boolean qrActivated) {
        isQrActivated = qrActivated;
    }




    //-------------create database sessions-------------------------->

    public static void verifyGuestId() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Reservations.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Reservations res = (Reservations) session.get(Reservations.class, verifyId);
            res.verifyId.matches("");
            session.getTransaction().commit();

            System.out.println("Reservation Removed!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();

        }
        
    }

            public static void DeleteReservation(int roomNumber) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cf.xml")
                .addAnnotatedClass(Reservations.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Checking Guest Out Of Room: " + roomNumber);
            session.createQuery("delete from Reservations where roomNumber=" + roomNumber).executeUpdate();
            session.getTransaction().commit();

            System.out.println("Reservation Removed!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();

        }
    }

    public static void CheckIn(boolean isQrActivated, int roomNumber) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cf.xml")
                .addAnnotatedClass(Reservations.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Activating Guest Stay " + roomNumber);
            Hotelrooms room = (Hotelrooms) session.get(Hotelrooms.class, roomNumber);
            room.setIsAvailable(room.isAvailable());room.setIsAvailable(room.getIsAvailable());
            room.setCheckIn(room.getCheckIn());
            room.setCheckOut(room.getCheckOut());
            Reservations res = (Reservations) session.get(Reservations.class,isQrActivated);
            res.setQrActivated(res.isQrActivated);
            room.setCheckIn(room.getCheckIn());
            room.setCheckOut(room.getCheckOut());

            session.getTransaction().commit();
            System.out.println("Guest Checked In and Reservation Complete!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();

        }

    }


}


