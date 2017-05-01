package ch.frankel.blog.serviceloader;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaServiceLoaderTest {

    @Test
    public void java_service_loader_should_load_correct_implementations() {
        ServiceLoader<Foo> loader = ServiceLoader.load(Foo.class);
        List<Foo> foos = new ArrayList<>();
        loader.iterator().forEachRemaining(foos::add);
        assertThat(foos)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2);
    }
}
