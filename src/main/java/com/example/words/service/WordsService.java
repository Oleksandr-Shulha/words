package com.example.words.service;

import java.util.List;
import java.util.Map;
import com.example.words.dao.WordsDao;
import com.example.words.model.Game;
import org.springframework.stereotype.Service;

@Service
public class WordsService {
    private WordsDao wordsDao;

    public WordsService(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
    }

    public Game validateWords(Map<String, List<String>> words) {
        return wordsDao.validateWords(words);
    }
}
