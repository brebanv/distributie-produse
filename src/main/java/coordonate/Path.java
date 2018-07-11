package coordonate;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private String encodedPath;

    public Path(String encodedPath) {
        this.encodedPath = encodedPath;
    }

    public List<Punct> decode() {
        int len = encodedPath.length();
        final List<Punct> path = new ArrayList<>();
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

            path.add(new Punct(lat * 1e-5, lng * 1e-5));
        }
        return path;
    }
}
