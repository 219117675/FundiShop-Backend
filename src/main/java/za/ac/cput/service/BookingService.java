package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.enums.BookingStatus;
import za.ac.cput.repository.BookingRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService extends BaseService<Booking> {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository repository) {
        super(repository);
        this.bookingRepository = repository;
    }

    public List<Booking> getBookingsByFundi(Long fundiProfileId) {
        return bookingRepository
                .findByFundiProfileIdOrderByCreatedAtDesc(
                        fundiProfileId
                );
    }

    public List<Booking> getBookingsByCustomer(Long customerId) {
        return bookingRepository
                .findByCustomerIdOrderByCreatedAtDesc(
                        customerId
                );



    }

    public Booking updateStatus(
            Long bookingId,
            BookingStatus status
    ) {
        Booking booking = bookingRepository
                .findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found"
                        )
                );

        booking.setStatus(status);

        return bookingRepository.save(booking);
    }

    public Booking rescheduleBooking(
            Long bookingId,
            LocalDate newDate,
            LocalTime newTime
    ) {
        Booking booking = bookingRepository
                .findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found"
                        )
                );

        booking.setScheduledDate(newDate);
        booking.setScheduledTime(newTime);
        booking.setStatus(BookingStatus.RESCHEDULED);

        return bookingRepository.save(booking);
    }
}