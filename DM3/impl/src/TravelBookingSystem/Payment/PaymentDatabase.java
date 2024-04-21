package TravelBookingSystem.Payment;

import java.util.Enumeration;

public interface PaymentDatabase
{
    void addPayment(Payment payment);
    Payment removePayment(String id);
    Payment getPayment(String id);
    Enumeration<Payment> getAllPayments();
}
