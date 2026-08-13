package barig.adam;

import barig.adam.parser.CityDTO;
import barig.adam.parser.CordsDTO;

public class Main {
    static void main() {
        CordsDTO coords = new CordsDTO(59.939095, 30.315868);
        CityDTO a = new CityDTO("spb", coords);

        System.out.println(a.getCoords().getLon());
    }
}
