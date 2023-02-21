package Wiki.service;

import Wiki.module.Wiki;

import java.util.List;

public interface WikiService {
    List<Wiki> findAllByTitle();
}
