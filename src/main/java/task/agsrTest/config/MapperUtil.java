package task.agsrTest.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.agsrTest.model.Sensor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MapperUtil {


    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    public static <E, R> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }
}