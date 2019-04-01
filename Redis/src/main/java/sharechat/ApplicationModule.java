package sharechat;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.yammer.dropwizard.config.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import sharechat.ApplicationConfiguration;

/**
 * Created by amit_k on 4/1/19.
 */
public class ApplicationModule extends AbstractModule{

    @Override
    protected void configure()
    {

    }

    @Provides
    public ApplicationConfiguration configuration(Configuration configuration)
    {
        return (ApplicationConfiguration) configuration;
    }

    @Provides
    public JedisPool provideJedisPool(ApplicationConfiguration applicationConfiguration)
    {
        RedisConfiguration redisConfig = applicationConfiguration.getRedis();
        return new JedisPool(
                new JedisPoolConfig(),
                redisConfig.getHostname(),
                redisConfig.getPort() );
    }
}
