package arsiv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "musteri")
public class Musteri {
    @Id
    @SequenceGenerator(name = "seq_musteri", allocationSize = 1)
    @GeneratedValue(generator = "seq_musteri", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String musteriAd;

    private String musteriSoyad;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "musteri_id")
    private Set<Dosya> dosyalar;

}
