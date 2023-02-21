package Wiki.repositories;

import Wiki.module.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<Wiki,Integer> {
    Wiki findByTitle(String title);
}
