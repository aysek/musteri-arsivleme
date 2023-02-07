package arsiv.repo;

import arsiv.entity.Kullanici;
import arsiv.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
}
