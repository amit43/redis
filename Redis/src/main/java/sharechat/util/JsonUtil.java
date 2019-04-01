package sharechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by amit_k on 4/1/19.
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static final String toJson(Object o)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(o);

        } catch (JsonProcessingException e) {

            logger.error("Json Processing was wrong", logger);
        }

        return null;
    }
}
