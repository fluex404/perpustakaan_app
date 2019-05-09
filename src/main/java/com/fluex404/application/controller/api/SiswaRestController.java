package com.fluex404.application.controller.api;

import com.fluex404.application.entity.Siswa;
import com.fluex404.application.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siswa")
public class SiswaRestController {
    @Autowired
    private SiswaService service;

    @GetMapping
    public ResponseEntity<List<Siswa>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Siswa> findById(@PathVariable("id") Siswa siswa) {
        return new ResponseEntity<>(siswa, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Siswa siswa){
        return new ResponseEntity<>(service.deleteSiswa(siswa), HttpStatus.OK);
    }
}
