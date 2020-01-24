package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private TimeEntry timeEntry = new TimeEntry();
    private HashMap<Long, TimeEntry> timeEntryHashMap = new HashMap<Long, TimeEntry>() ;
    private long timeEntryId=1;

    public TimeEntry create(TimeEntry any){
        this.timeEntry = any;
        if (any.getId()== 0){
            timeEntry.setId(timeEntryId);
        }
        timeEntryHashMap.put(timeEntryId, timeEntry);
        timeEntryId++;
        return timeEntry;
    }

    public TimeEntry find(long timeEntryId ){
        return timeEntryHashMap.get(timeEntryId);
    }

    @Override
    public TimeEntry find(Long id) {
        return null;
    }

    public TimeEntry update(long eq,TimeEntry any ){
        if (timeEntryHashMap.get(eq)== null) {
                return null;
            }
        else
        {
            this.timeEntry = any;
            if (any.getId() == 0) {
                timeEntry.setId(eq);
            }
            timeEntryHashMap.replace(eq, timeEntry);

            return timeEntry;
        }
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public void delete(long timeEntryId ) {
        timeEntryHashMap.remove(timeEntryId);
    }

    public List list( ) {
        return new ArrayList<TimeEntry>(timeEntryHashMap.values());
    }
}

