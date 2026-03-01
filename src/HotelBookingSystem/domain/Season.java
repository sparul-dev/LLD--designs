package HotelBookingSystem.domain;

import java.util.Date;
import java.util.UUID;

public class Season {

    private UUID id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Long priority;

    public Season(String name, Date startDate, Date endDate, Long priority) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
