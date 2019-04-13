package model;

import org.springframework.data.cassandra.mapping.PrimaryKey;

public abstract class AbstractModel {
    @PrimaryKey("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
