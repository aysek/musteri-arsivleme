package arsiv.repo;

import arsiv.entity.Dosya;
import arsiv.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DosyaRepository extends JpaRepository<Dosya,Long> {
}
