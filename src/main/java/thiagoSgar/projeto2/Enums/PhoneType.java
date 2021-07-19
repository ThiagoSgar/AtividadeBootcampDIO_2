package thiagoSgar.projeto2.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("home"),
    MOBILE("mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
