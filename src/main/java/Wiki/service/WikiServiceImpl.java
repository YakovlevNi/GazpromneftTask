package Wiki.service;

import Wiki.module.Wiki;
import Wiki.repositories.WikiRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WikiServiceImpl implements WikiService {
    @Autowired
    private final WikiRepository wikiRepository;

    @Override
    public List<Wiki> findAllByTitle() {
        List < Wiki > titles = wikiRepository.findAll();
        return titles;

    }
}
