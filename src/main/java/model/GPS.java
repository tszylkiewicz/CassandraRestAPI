package model;

import org.springframework.data.cassandra.mapping.Table;

@Table("gps")
public class GPS extends AbstractModel {
    private float lat;
    private float lng;

    public GPS() {
        super();
    }

    public GPS(float lat, float lng) {
        super();
        this.lat = lat;
        this.lng = lng;

    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
