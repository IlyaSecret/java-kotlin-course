package barig.adam;

import barig.adam.parser.CityDTO;
import barig.adam.parser.CordsDTO;
import barig.adam.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Parser p = new Parser();

        p.toXML();
    }
}
