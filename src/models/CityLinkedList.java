package models;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class CityLinkedList extends LinkedList<City> {
    private LocalDateTime creationDate;
    public CityLinkedList () {
        super();
        creationDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
