package ch.frankel.blog.serviceloader;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class ServiceLoaderWithSpringTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ServiceListFactoryBean serviceListFactoryBean;

    @Test
    public void spring_service_loader_integration_should_load_correct_implementations() throws Exception {
        Object object = serviceListFactoryBean.getObject();
        Assertions.assertThat(object)
                .isNotNull()
                .asList()
                .isNotEmpty()
                .hasSize(2);
    }
}
