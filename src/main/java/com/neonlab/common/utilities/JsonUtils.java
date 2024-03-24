package com.neonlab.common.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.neonlab.common.constants.GlobalConstants;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.neonlab.common.constants.GlobalConstants.EMPTY_STRING;

@Slf4j
@UtilityClass
public class JsonUtils {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private static final String PARSING_EXCEPTION_MESSAGE = "Exception occurred while converting from object: {} to json";


    public static String jsonOf(final Object value){
        try{
            if (Objects.nonNull(value)) {
                return mapper.writeValueAsString(value);
            } else {
                return EMPTY_STRING;
            }
        } catch (Exception e) {
            log.warn(PARSING_EXCEPTION_MESSAGE, value, e);
        }
        return EMPTY_STRING;
    }

}
