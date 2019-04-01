package sharechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by amit_k on 4/1/19.
 */
public class ApplicationConfiguration extends Configuration{

    public static final String APP_NAME = "ShareChat";

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @Valid
    @NotNull
    @JsonProperty
    private RedisConfiguration redis = new RedisConfiguration();

    public RedisConfiguration getRedis()
    {
        return redis;
    }

}
