package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.User;
import za.ac.cput.domain.enums.BookingStatus;
import za.ac.cput.dto.BookingRequest;
import za.ac.cput.dto.RescheduleRequest;
import za.ac.cput.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController extends BaseController<Booking> {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Booking createEntity(Booking entity) {
        return service.create(entity);
    }

    @Override
    protected Booking updateEntity(Booking entity) {
        return service.update(entity);
    }

    @Override
    protected Booking getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Booking> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }


    /*
     * ==========================================
     * CREATE BOOKING
     * ==========================================
     */

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(
            @RequestBody BookingRequest request
    ) {

        Booking booking = new Booking();

        User customer = new User();
        customer.setId(request.getCustomerId());

        FundiProfile fundiProfile =
                new FundiProfile();

        fundiProfile.setId(
                request.getFundiProfileId()
        );

        booking.setCustomer(customer);

        booking.setFundiProfile(
                fundiProfile
        );

        booking.setScheduledDate(
                request.getScheduledDate()
        );

        booking.setScheduledTime(
                request.getScheduledTime()
        );

        booking.setServiceRequired(
                request.getServiceRequired()
        );

        booking.setJobLocation(
                request.getJobLocation()
        );

        booking.setEstimatedBudget(
                request.getEstimatedBudget()
        );

        booking.setJobDescription(
                request.getJobDescription()
        );

        Booking savedBooking =
                service.create(booking);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBooking);
    }


    /*
     * ==========================================
     * GET BOOKINGS FOR FUNDI
     * ==========================================
     */

    @GetMapping("/fundi/{fundiProfileId}")
    public ResponseEntity<List<Booking>> getFundiBookings(
            @PathVariable Long fundiProfileId
    ) {

        return ResponseEntity.ok(
                service.getBookingsByFundi(
                        fundiProfileId
                )
        );
    }


    /*
     * ==========================================
     * GET BOOKINGS FOR HOMEOWNER
     * ==========================================
     */

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getCustomerBookings(
            @PathVariable Long customerId
    ) {

        return ResponseEntity.ok(
                service.getBookingsByCustomer(
                        customerId
                )
        );
    }


    /*
     * ==========================================
     * UPDATE BOOKING STATUS
     * ==========================================
     *
     * Example:
     *
     * PUT
     * /api/bookings/5/status?status=ACCEPTED
     *
     * Possible statuses:
     *
     * REQUESTED
     * ACCEPTED
     * DECLINED
     * RESCHEDULED
     * COMPLETED
     * CANCELLED
     *
     */

    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable Long id,
            @RequestParam BookingStatus status
    ) {

        return ResponseEntity.ok(
                service.updateStatus(
                        id,
                        status
                )
        );
    }


    /*
     * ==========================================
     * RESCHEDULE BOOKING
     * ==========================================
     *
     * Example:
     *
     * PUT
     * /api/bookings/5/reschedule
     * Body: { "scheduledDate": "2026-09-01", "scheduledTime": "14:00" }
     *
     * Sets the new date/time and flips status to RESCHEDULED.
     *
     */

    @PutMapping("/{id}/reschedule")
    public ResponseEntity<Booking> rescheduleBooking(
            @PathVariable Long id,
            @RequestBody RescheduleRequest request
    ) {

        return ResponseEntity.ok(
                service.rescheduleBooking(
                        id,
                        request.getScheduledDate(),
                        request.getScheduledTime()
                )
        );
    }


}