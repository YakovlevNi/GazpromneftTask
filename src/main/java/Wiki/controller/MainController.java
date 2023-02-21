package Wiki.controller;

import Wiki.module.Category;
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

    final String PATH ="D:\\JSON\\ruwiki-20221212-cirrussearch-general.json";
    @Autowired
    final Parser parser;
    @Autowired
    final WikiService wikiService;
    @Autowired
    final WikiRepository wikiRepository;
    @Autowired
    final CategoryRepository categoryRepository;


    @GetMapping("/info/{title}")
    public Object getInfoTitle(@PathVariable String title, String info) {
        Wiki wiki = wikiRepository.findByTitle(title);
        if (info != null) {
            return wiki;
        }
        return wiki.toString();
    }

    @GetMapping("/info/{category}")
    public Object getInfoCat(@PathVariable String cat, String info) {
        Category category = categoryRepository.findByCategory(cat);
        if (info != null) {
            return cat;
        }
        return cat.toString();
    }

    @GetMapping("/parse")
    public String parse() {
        if (PATH != null) {
            parser.parserJSON(PATH);
            return "parse";
        }
        return null;
    }
    @GetMapping("/")
    public String showAllTitle(Model model){
        model.addAttribute("title",wikiService.findAllByTitle());
        return "wiki";
    }

}
