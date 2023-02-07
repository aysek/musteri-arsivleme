package arsiv.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dosya")
public class Dosya {

    @Id
    @SequenceGenerator(name = "seq_dosya", allocationSize = 1)
    @GeneratedValue(generator = "seq_dosya", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String dosyaAdi;

    @OneToOne
    @JoinColumn(name = "musteri_id")
    private Musteri musteri;
}
