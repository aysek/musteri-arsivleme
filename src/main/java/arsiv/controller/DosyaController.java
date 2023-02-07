package arsiv.controller;

import arsiv.entity.Dosya;
import arsiv.entity.Musteri;
import arsiv.repo.DosyaRepository;
import arsiv.repo.MusteriRepository;
import arsiv.request.DosyaRequest;
import arsiv.request.MusteriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/dosya")
public class DosyaController {
    @Autowired
    DosyaRepository dosyaRepository;
    @Autowired
    MusteriRepository musteriRepository;

    @PostMapping("/{musteriId}/dosyalar")
    public Dosya dosyaEkle(@PathVariable Long musteriId, @RequestBody DosyaRequest dosyaRequest){
        Musteri musteri = musteriRepository.findById(musteriId).orElseThrow(NoSuchElementException::new);
        Dosya dosya = new Dosya();
        dosya.setDosyaAdi(dosyaRequest.getDosyaAd());
        dosya.setMusteri(musteri);
        dosyaRepository.save(dosya);
        return dosya;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Dosya dosyaGetir(@PathVariable Long id) {
        return dosyaRepository.findById(id).orElseThrow();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Dosya> dosyaListesiGetir() {
        return dosyaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void dosyaSil(@PathVariable Long id) {
        dosyaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dosya dosyaDuzenle(@PathVariable Long id, @RequestBody DosyaRequest dosyaRequest) {
        Dosya dosya = dosyaRepository.findById(id).orElseThrow();
        dosya.setDosyaAdi(dosyaRequest.getDosyaAd());
        return dosyaRepository.save(dosya);
    }





}
