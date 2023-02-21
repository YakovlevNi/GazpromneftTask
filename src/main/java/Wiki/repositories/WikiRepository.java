package Wiki.repositories;

import Wiki.module.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WikiRepository extends JpaRepository<Wiki,Integer> {
    Wiki findByTitle(String title);


}
