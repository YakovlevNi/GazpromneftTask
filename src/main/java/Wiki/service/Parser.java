package Wiki.service;

import Wiki.WikiApplication;
import Wiki.module.Category;
import Wiki.module.Wiki;
import Wiki.repositories.CategoryRepository;
import Wiki.repositories.WikiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class Parser {
    @Autowired
    final CategoryRepository categoryRepository;
    @Autowired
    final WikiRepository wikiRepository;



    public void parserJSON(String filePath) {
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
            String line;
            Set<String> cS = new HashSet<>();

            while ((line = bufferReader.readLine()) != null) {
                if (line.contains("template")) {
                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(line);

                    String date = String.valueOf(jsonObject.get("create_timestamp"));
                    date = date.replace("Z", "");
                    LocalDateTime startDate = LocalDateTime.parse(date);

                    date = String.valueOf(jsonObject.get("timestamp"));
                    date = date.replace("Z", "");
                    LocalDateTime dateTime = LocalDateTime.parse(date);

                    Wiki wikiModel = new Wiki();
                    wikiModel.setWiki(String.valueOf(jsonObject.get("wiki")));
                    wikiModel.setAuxiliary_text(String.valueOf(jsonObject.get("auxiliary_text")));
                    wikiModel.setCreateTimestamp(startDate);
                    wikiModel.setLanguage(String.valueOf(jsonObject.get("language")));
                    wikiModel.setTitle(String.valueOf(jsonObject.get("title")));
                    wikiModel.setTimestamp(dateTime);

                    JSONArray jsonArray = (JSONArray) jsonObject.get("category");

                    Set<Category> wikisCat = new HashSet<>();
                    for (Object o : jsonArray) {
                        String c = String.valueOf(o);
                        if (!cS.contains(c)) {
                            Category category = new Category();
                            category.setCategory(c);
                            categoryRepository.save(category);
                            cS.add(c);
                        }
                        wikisCat.add(categoryRepository.findByCategory(c));
                    }
                    wikiModel.setCategories(wikisCat);

                    wikiRepository.save(wikiModel);
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
