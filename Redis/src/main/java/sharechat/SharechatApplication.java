package sharechat;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created by amit_k on 4/1/19.
 */
public class SharechatApplication extends Service<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception
    {
        new SharechatApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap)
    {
        bootstrap.setName("dropwizard-redis");
        bootstrap.addBundle(GuiceBundle.newBuilder()
                .addModule(new ApplicationModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .build()
        );
    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception
    {

    }
}
