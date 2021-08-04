package thiagoSgar.projeto2.utils;

import thiagoSgar.projeto2.entities.Phone;
import thiagoSgar.projeto2.enums.PhoneType;
import thiagoSgar.projeto2.dto.request.PhoneDTO;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1691234-5678";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
