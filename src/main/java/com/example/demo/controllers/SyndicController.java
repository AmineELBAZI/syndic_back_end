package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Syndic;
import com.example.demo.repositoris.SyndicRepositori;

import java.util.List;

@RestController
@RequestMapping("/syndics")
@CrossOrigin("http://localhost:3000")
public class SyndicController {

    private final SyndicRepositori syndicRepository;

    @Autowired
    public SyndicController(SyndicRepositori syndicRepository) {
        this.syndicRepository = syndicRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Syndic>> getAllSyndics() {
        List<Syndic> syndics = syndicRepository.findAll();
        return new ResponseEntity<>(syndics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Syndic> getSyndicById(@PathVariable int id) {
        Syndic syndic = syndicRepository.findById(id).orElse(null);
        if (syndic != null) {
            return new ResponseEntity<>(syndic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Syndic> addSyndic(@RequestBody Syndic syndic) {
        Syndic savedSyndic = syndicRepository.save(syndic);
        return new ResponseEntity<>(savedSyndic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Syndic> updateSyndic(@PathVariable int id, @RequestBody Syndic updatedSyndic) {
        Syndic existingSyndic = syndicRepository.findById(id).orElse(null);
        if (existingSyndic != null) {
            existingSyndic.setAdresse(updatedSyndic.getAdresse());
            existingSyndic.setStatut_day(updatedSyndic.getStatut_day());
            existingSyndic.setNom(updatedSyndic.getNom());
            existingSyndic.setEmail(updatedSyndic.getEmail());
            existingSyndic.setStatut_day(updatedSyndic.getStatut_day());
            existingSyndic.setAdresse(updatedSyndic.getAdresse());
            
            
            Syndic updated = syndicRepository.save(existingSyndic);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSyndic(@PathVariable int id) {
        Syndic existingSyndic = syndicRepository.findById(id).orElse(null);
        if (existingSyndic != null) {
            syndicRepository.delete(existingSyndic);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

