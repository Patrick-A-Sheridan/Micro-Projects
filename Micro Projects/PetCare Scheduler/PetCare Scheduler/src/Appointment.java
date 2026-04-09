import java.time.LocalDateTime;

public class Appointment {
    private final int petId;
    private final LocalDateTime dateAndTime;
    private final String appointmentType;
    private final String notes;

    public Appointment(int petId, LocalDateTime dateAndTime, String appointmentType, String notes) {
        if (dateAndTime == null) {
            throw new IllegalArgumentException("dateAndTime cannot be null");
        }
        if (appointmentType == null || appointmentType.isBlank()) {
            throw new IllegalArgumentException("appointmentType cannot be blank");
        }

        this.petId = petId;
        this.dateAndTime = dateAndTime;
        this.appointmentType = appointmentType;
        this.notes = (notes == null) ? "" : notes;
    }

    public Appointment(int petId, LocalDateTime dateAndTime, String appointmentType) {
        this(petId, dateAndTime, appointmentType, "");
    }

    public int getPetId() {
        return petId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Pet ID: " + petId
                + " | Date/Time: " + dateAndTime
                + " | Type: " + appointmentType
                + " | Notes: " + notes;
    }
}