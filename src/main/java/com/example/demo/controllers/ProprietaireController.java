package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Proprietaire;
import com.example.demo.repositoris.ProprietaireRepositori;

import java.util.List;

@RestController
@RequestMapping("/proprietaires")
@CrossOrigin("http://localhost:3000")
public class ProprietaireController {

    private final ProprietaireRepositori proprietaireRepository;

    @Autowired
    public ProprietaireController(ProprietaireRepositori proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proprietaire>> getAllProprietaires() {
        List<Proprietaire> proprietaires = proprietaireRepository.findAll();
        return new ResponseEntity<>(proprietaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietaire> getProprietaireById(@PathVariable int id) {
        Proprietaire proprietaire = proprietaireRepository.findById(id).orElse(null);
        if (proprietaire != null) {
            return new ResponseEntity<>(proprietaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Proprietaire> addProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire savedProprietaire = proprietaireRepository.save(proprietaire);
        return new ResponseEntity<>(savedProprietaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietaire> updateProprietaire(@PathVariable int id, @RequestBody Proprietaire updatedProprietaire) {
        Proprietaire existingProprietaire = proprietaireRepository.findById(id).orElse(null);
        if (existingProprietaire != null) {
           
            existingProprietaire.setNom(updatedProprietaire.getNom());
            existingProprietaire.setEmail(updatedProprietaire.getEmail());
            
            // Set additional properties
            existingProprietaire.setType(updatedProprietaire.getType());
           
            existingProprietaire.setNom_vehicule(updatedProprietaire.getNom_vehicule());
            existingProprietaire.setMatricule_vehicule(updatedProprietaire.getMatricule_vehicule());
            existingProprietaire.setDepense(updatedProprietaire.getDepense());
            existingProprietaire.setDepense_statu(updatedProprietaire.isDepense_statu());
            // End of additional properties

            Proprietaire updated = proprietaireRepository.save(existingProprietaire);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprietaire(@PathVariable int id) {
        Proprietaire existingProprietaire = proprietaireRepository.findById(id).orElse(null);
        if (existingProprietaire != null) {
            proprietaireRepository.delete(existingProprietaire);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
