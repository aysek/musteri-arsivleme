package arsiv.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Kullanici {
    @Id
    private Long id;

    private String kullaniciAd;

    private String kullaniciSoyad;
}
