package note.javadev_homework_16.utils;

import note.javadev_homework_16.repositorys.NoteRepository;
import note.javadev_homework_16.service.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "note.javadev_homework_16")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public NoteService noteService(NoteRepository noteRepository) {
        return new NoteService(noteRepository);
    }

}