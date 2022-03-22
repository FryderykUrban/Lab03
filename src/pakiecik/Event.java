package pakiecik;


import java.util.ArrayList;
import java.util.List;

public class Event {

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String applicationDate;
    private String status; //edytowana zgłoszona zakończona
    private float preparation;

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> participants = new ArrayList();

    public Event(String eventName, String eventDescription, String eventDate, String applicationDate, String status, float preparation) {

        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.applicationDate = applicationDate;
        this.status = status;
        this.preparation = preparation;
    }
    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public float getPreparation() {
        return preparation;
    }
}