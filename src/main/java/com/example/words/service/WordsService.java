package com.example.words.service;

import java.util.List;
import java.util.Map;
import com.example.words.dao.WordsDao;
import com.example.words.model.Game;

public class WordsService {
    public Game validateWords(Map<String, List<String>> words) {
        return WordsDao.validateWords(words);
    }
}
