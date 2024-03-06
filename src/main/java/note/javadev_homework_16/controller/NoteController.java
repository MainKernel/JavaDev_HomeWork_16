package note.javadev_homework_16.controller;

import note.javadev_homework_16.entity.NoteEntity;
import note.javadev_homework_16.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/noteEntity")
public class NoteController {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/list")
    public ModelAndView getNoteList() {
        List<NoteEntity> all = noteService.findAll();
        ModelAndView modelAndView = new ModelAndView("note/noteList");
        modelAndView.addObject("notes", all);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam("id") Long id) {
        noteService.remove(id);
        return new ModelAndView("redirect:/noteEntity/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") Long id) {
        NoteEntity byId = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("note/noteEdit");
        modelAndView.addObject("note", byId);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute NoteEntity note) {
        noteService.update(note);
        return new ModelAndView("redirect:/noteEntity/list");
    }

    @GetMapping("/create")
    public ModelAndView createNote() {
        return new ModelAndView("note/createNote");
    }

    @PostMapping("/create")
    public ModelAndView createNote(@ModelAttribute NoteEntity note) {
        noteService.save(note);
        return new ModelAndView("redirect:/noteEntity/list");
    }
}
