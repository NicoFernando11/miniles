package com.MiniLes.service;

import com.MiniLes.dto.tutor.TutorGridDTO;
import com.MiniLes.dto.tutor.UpsertTutorDTO;
import com.MiniLes.entity.Student;
import com.MiniLes.entity.Tutor;
import com.MiniLes.exception.NotFoundException;
import com.MiniLes.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements TutorService{

    @Autowired
    private TutorRepository tutorRepository;


    @Override
    public Tutor findById(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Tutor with number "+id+" not Found"));

    }

    @Override
    public void saveTutor(UpsertTutorDTO dto) {
        Tutor tutor = new Tutor(
                dto.getName(),
                dto.getGender(),
                dto.getAddress(),
                dto.getBirthDate(),
                dto.getHobby(),
                dto.getEmail()
        );

        tutorRepository.save(tutor);
    }

    @Override
    public void updateTutor(UpsertTutorDTO dto) {
        Optional<Tutor> theTutor= tutorRepository.findById(dto.getId());

        Tutor tutor =theTutor.get();

        tutor.setName(dto.getName());
        tutor.setGender(dto.getGender());
        tutor.setAddress(dto.getAddress());
        tutor.setBirthDate(dto.getBirthDate());
        tutor.setHobby(dto.getHobby());
        tutor.setEmail(dto.getEmail());

        tutorRepository.save(tutor);

    }

    @Override
    public void deleteTutor(Long id) {
        Optional<Tutor> theTutor= tutorRepository.findById(id);

        tutorRepository.delete(theTutor.get());

    }

    @Override
    public List<TutorGridDTO> findAllTutor(String name) {
        List<TutorGridDTO> gridDTO = new LinkedList<>();

        tutorRepository.findByName(name).stream()
                .forEach(each -> gridDTO.add(each.convertToGrid()));

        return gridDTO;
    }
}
