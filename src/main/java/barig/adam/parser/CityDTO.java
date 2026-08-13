package barig.adam.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityDTO {
    private String slug;

    private CordsDTO coords;
}

