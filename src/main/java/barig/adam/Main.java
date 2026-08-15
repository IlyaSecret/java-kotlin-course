package barig.adam;

import barig.adam.dto.CityDTO;
import barig.adam.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Parser p = new Parser();

        CityDTO data = p.parse("test-erer.json");
        if (data != null) {
            p.toXML(data);
        }
    }
}
