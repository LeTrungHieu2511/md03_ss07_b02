package com.example.md03.service;

import com.example.md03.dto.CandidateCreateDTO;
import com.example.md03.model.Candidate;
import com.example.md03.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate create(CandidateCreateDTO dto) {
        Candidate c = new Candidate();
        c.setFullName(dto.getFullName());
        c.setEmail(dto.getEmail());
        c.setAge(dto.getAge());
        c.setYearsOfExperience(dto.getYearsOfExperience());
        return candidateRepository.save(c);
    }
}