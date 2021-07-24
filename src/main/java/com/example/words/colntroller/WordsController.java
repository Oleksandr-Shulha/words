package com.example.words.colntroller;

import java.util.List;
import java.util.Map;

import com.example.words.service.WordsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
public class WordsController {
    private WordsService wordsService;

    public WordsController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @RequestMapping(value = "/words", method = RequestMethod.POST)
    public Map<String, List<String>> post(@RequestBody Map<String, List<String>> words) {
        return wordsService.validateWords(words).getWords();
    }
}
