package com.test.RestApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.RestApi.Ent.lokasi;
import com.test.RestApi.Services.lokasiService;
@RestController
@RequestMapping("/lokasi")
public class lokasiController {
    @Autowired
    private lokasiService lokasiService;

    @PostMapping
    public lokasi addLokasi(@RequestBody lokasi lokasi) {
        return lokasiService.addLokasi(lokasi);
    }

    @GetMapping
    public List<lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }

    @PutMapping("/{id}")
    public lokasi updateLokasi(@PathVariable int id, @RequestBody lokasi lokasiDetails) {
        return lokasiService.updateLokasi(id, lokasiDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLokasi(@PathVariable int id) {
        lokasiService.deleteLokasi(id);
        return ResponseEntity.ok().build();
    }
}
