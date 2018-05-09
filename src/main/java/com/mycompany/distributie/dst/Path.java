package com.mycompany.distributie.dst;

import java.util.ArrayList;
import java.util.List;

public class Path {

    String encodedPath;

    public Path(String encodedPath) {
        this.encodedPath = encodedPath;
    }

    public List<Point> decode() {
        int len = encodedPath.length();

        // For speed we preallocate to an upper bound on the final length, then
        // truncate the array before returning.
        final List<Point> path = new ArrayList<>();
        int index = 0;
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int result = 1;
            int shift = 0;
            int b;
            do {
                b = encodedPath.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            } while (b >= 0x1f);
            lat += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            result = 1;
            shift = 0;
            do {
                b = encodedPath.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            } while (b >= 0x1f);
            lng += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            path.add(new Point(lat * 1e-5, lng * 1e-5));
        }

        return path;
    }
}
