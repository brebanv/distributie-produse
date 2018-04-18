
package com.mycompany.distributie.dst;

import java.io.Serializable;
import java.util.Locale;

public class LatLng implements Serializable {
    
  public double lat;
  public double lng;

  public LatLng(double lat, double lng) {
    this.lat = lat;
    this.lng = lng;
  }

  public LatLng() {}

  @Override
  public String toString() {
    return toUrlValue();
  }

  public String toUrlValue() {
    return String.format(Locale.ENGLISH, "%.8f,%.8f", lat, lng);
  }
}