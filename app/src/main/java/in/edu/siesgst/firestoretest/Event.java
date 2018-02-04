package in.edu.siesgst.firestoretest;

import java.util.List;

/**
 * Created by aditya on 4/2/18.
 */

public class Event {

    private String category,day,description,rules,tags,event_name,time,event_id,poster_portrait,poster_landscape,venue,type;
    private Long price;
    private List<String> deviceID,participants,event_heads;


    public Event() {
    }

    public String getCategory() {
        return category;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {return description;}

    public Long getPrice() {
        return price;
    }

    public String getRules() {
        return rules;
    }

    public String getTags() {
        return tags;
    }

    public List<String> getDeviceID() {
        return deviceID;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getTime() {
        return time;
    }

    public String getEvent_id() {
        return event_id;
    }

    public String getPoster_portrait() {
        return poster_portrait;
    }

    public String getPoster_landscape() {
        return poster_landscape;
    }

    public List<String> getEvent_heads() {
        return event_heads;
    }

    public String getVenue() {
        return venue;
    }

    public String getType() {
        return type;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
