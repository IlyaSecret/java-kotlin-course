package barig.adam.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final ObjectMapper xmlMapper = new XmlMapper();

    public CityDTO parse() throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/test.json")) {
            if (is == null) {
                throw new IOException("Resource not found: /test.json");
            }
            return jsonMapper.readValue(is, CityDTO.class);
        }
    }

    public void toXML() throws IOException {
        try (OutputStream os = Files.newOutputStream(Paths.get("build/resources/main/stuff.xml"))) {
        xmlMapper.writeValue(os, this.parse());
        }
    }
}
