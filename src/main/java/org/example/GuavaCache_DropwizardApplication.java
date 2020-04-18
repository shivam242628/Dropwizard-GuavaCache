package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.cache.CacheConfigManager;
import org.example.resources.CacheResource;
import org.example.service.StudentService;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class GuavaCache_DropwizardApplication extends Application<GuavaCache_DropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GuavaCache_DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "GuavaCache_Dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<GuavaCache_DropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GuavaCache_DropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        CacheConfigManager cacheConfigManager = CacheConfigManager
                .getInstance();
        StudentService studentService = new StudentService();
        cacheConfigManager.initStudentCache(studentService);
        environment.jersey().register(new CacheResource());
    }

}
