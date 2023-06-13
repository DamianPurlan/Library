//package pl.damian.purlan.biblioteka.dataprovider;
//
//import lombok.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//import org.springframework.core.io.Resource;
//@Component
//public class Reader implements CommandLineRunner {
//
//    @Value("classpath:data.sql")
//    private Resource resource;
//
//    @Override
//    public void run(String... args) throws Exception {
//        String filePathString = resource.getFile().getPath();
//        Path of = Path.of(filePathString);
//        List<String> strings = Files.readAllLines(of);
//        strings.stream().forEach(System.out::println);
//    }
//}
