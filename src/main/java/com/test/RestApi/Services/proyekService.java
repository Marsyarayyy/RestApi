package com.test.RestApi.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.RestApi.Ent.proyek;
import com.test.RestApi.repo.proyekRepo;

@Service
public class proyekService {
    @Autowired
    private proyekRepo proyekRepository;

    public proyek addProyek(proyek proyek) {
        proyek.setCreatedAt(LocalDateTime.now());
        return proyekRepository.save(proyek);
    }

    public List<proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public proyek updateProyek(int id, proyek proyekDetails) {
        proyek proyek = proyekRepository.findById(id).orElseThrow();
        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());
        return proyekRepository.save(proyek);
    }

    public void deleteProyek(int id) {
        proyekRepository.deleteById(id);
    }

    
}
