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

import com.test.RestApi.Ent.proyek;
import com.test.RestApi.Services.proyekService;

@RestController
@RequestMapping("/proyek")
public class proyekController {
    @Autowired
    private proyekService proyekService;

    @PostMapping
    public proyek addProyek(@RequestBody proyek proyek) {
        return proyekService.addProyek(proyek);
    }

    @GetMapping
    public List<proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @PutMapping("/{id}")
    public proyek updateProyek(@PathVariable int id, @RequestBody proyek proyekDetails) {
        return proyekService.updateProyek(id, proyekDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProyek(@PathVariable int id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.ok().build();
    }
}
   