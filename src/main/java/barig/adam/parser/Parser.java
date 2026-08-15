package barig.adam.parser;

import barig.adam.dto.CityDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final ObjectMapper xmlMapper = new XmlMapper();

    private static final Logger logger =  LoggerFactory.getLogger(Parser.class);

    public CityDTO parse(String fileName) {
        logger.info("Parsing file: {}", fileName);
        try (InputStream is = getClass().getResourceAsStream(String.format("/%s", fileName))) {
            if (is == null) {
                logger.error("File not found: {}", fileName);
                return null;
            }

            CityDTO data = jsonMapper.readValue(is, CityDTO.class);
            if (data.getCoords() == null  || data.getSlug() == null) {
                logger.warn("Data in file is not full {}", fileName);
            }
            return data;
        }
        catch (IOException e) {
            logger.error("Failed to parse file: {}",fileName, e );
            return null;
        }
    }

    public void toXML(CityDTO data) {
        logger.info("Writing XML file: {}", data);
        try (OutputStream os = Files.newOutputStream(Paths.get("build/resources/main/stuff.xml"))) {
        xmlMapper.writeValue(os, data);
        logger.debug("Successfully wrote stuff to XML file: {}", data);
        logger.info("Successfully wrote stuff to XML file");
        }
        catch (IOException e) {
            logger.error("Failed to write xml file: {}", data, e);
        }
    }
}
