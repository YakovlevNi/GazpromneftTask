package Wiki.controller;

import Wiki.module.Wiki;
import Wiki.repositories.CategoryRepository;
import Wiki.repositories.WikiRepository;
import Wiki.service.Parser;
import Wiki.service.WikiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {
    @Autowired
    final Parser parser;
    @Autowired
    final WikiService wikiService;
    @Autowired
    final WikiRepository wikiRepository;
    @Autowired
    final CategoryRepository categoryRepository;


    @GetMapping("/wiki/{title}")
    public Object getInfo(@PathVariable String title, String info) {
        Wiki wiki = wikiRepository.findByTitle(title);
        if (info != null) {
            return wiki;
        }
        return wiki.toString();
    }

    @GetMapping("/update")
    public String update(@RequestParam(name = "path", required = false) String path) {
        path = "D:\\JSON\\ruwiki-20221212-cirrussearch-general.json";
        if (path != null) {
            parser.parserJSON(path);
            return "update";
        }
        return "null";
    }
    @GetMapping("/")
    public String showTitle(Model model){
        model.addAttribute("title",wikiService.findAllByTitle());
        return "wiki";
    }

}
