package arsiv.controller;

import arsiv.request.MusteriRequest;
import arsiv.entity.Musteri;
import arsiv.repo.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musteri")
public class MusteriController {
    @Autowired
    MusteriRepository musteriRepository;

    @PostMapping
    public Musteri musteriEkle(@RequestBody MusteriRequest musteriRequest){
        Musteri musteri = new Musteri();
        musteri.setMusteriAd(musteriRequest.getMusteriAd());
        musteri.setMusteriSoyad(musteriRequest.getMusteriSoyad());
        return musteriRepository.save(musteri);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Musteri musteriGetir(@PathVariable Long id) {
        return musteriRepository.findById(id).orElseThrow();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Musteri> musteriListesiGetir() {
        return musteriRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void musteriSil(@PathVariable Long id) {
        musteriRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Musteri musteriDuzenle(@PathVariable Long id, @RequestBody MusteriRequest musteriRequest) {
        Musteri musteri = musteriRepository.findById(id).orElseThrow();
        musteri.setMusteriAd(musteriRequest.getMusteriAd());
        musteri.setMusteriSoyad(musteriRequest.getMusteriSoyad());
        return musteriRepository.save(musteri);
    }
}

