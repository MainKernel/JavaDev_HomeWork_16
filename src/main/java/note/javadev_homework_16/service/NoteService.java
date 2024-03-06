package note.javadev_homework_16.service;

import lombok.RequiredArgsConstructor;
import note.javadev_homework_16.entity.NoteEntity;
import note.javadev_homework_16.interfaces.Crud;
import note.javadev_homework_16.repositorys.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements Crud<NoteEntity, Long> {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void save(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
    }

    @Override
    public List<NoteEntity> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public NoteEntity findById(Long aLong) {
        return noteRepository.findById(aLong).orElse(new NoteEntity());
    }

    @Override
    public void remove(Long aLong) {
        noteRepository.deleteById(aLong);
    }

    @Override
    public void update(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
    }
}
