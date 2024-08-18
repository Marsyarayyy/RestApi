package com.test.RestApi.Services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.RestApi.Ent.lokasi;
import com.test.RestApi.repo.lokasiRepo;

import jakarta.annotation.PostConstruct;

@Service
public class lokasiService {
    @Autowired
    private lokasiRepo lokasiRepository;

    public lokasi addLokasi(lokasi lokasi) {
        lokasi.setCreatedAt(LocalDateTime.now());
        return lokasiRepository.save(lokasi);
    }

    public List<lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public lokasi updateLokasi(int id, lokasi lokasiDetails) {
        lokasi lokasi = lokasiRepository.findById(id).orElseThrow();
        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());
        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(int id) {
        lokasiRepository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        lokasi lokasi1 = new lokasi(1, "Lokasi 1", "Indonesia", "Jawa Barat", "Bandung", LocalDateTime.now());
        lokasi lokasi2 = new lokasi(2, "Lokasi 2", "Indonesia", "Jawa Timur", "Surabaya", LocalDateTime.now());
        lokasi lokasi3 = new lokasi(3, "Lokasi 3", "Indonesia", "DKI Jakarta", "Jakarta", LocalDateTime.now());
        
        // Simpan data dummy ke database
        lokasiRepository.saveAll(Arrays.asList(lokasi1, lokasi2, lokasi3));
    }
}
