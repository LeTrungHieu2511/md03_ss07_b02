package com.example.md03.controller;

import com.example.md03.dto.CandidateCreateDTO;
import com.example.md03.model.Candidate;
import com.example.md03.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<Candidate> create(@Valid @RequestBody CandidateCreateDTO dto) {
        Candidate created = candidateService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
