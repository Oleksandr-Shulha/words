package com.example.words.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.example.words.model.Game;
import org.springframework.stereotype.Component;

@Component
public class WordsDao {
    private Game game;

    public Game validateWords(Map<String, List<String>> words) {
        game = new Game();
        List<String> inputLst = words.get("words");
        List<String> correctList = new ArrayList<>();
        if (!inputLst.isEmpty()) {
            game.setGameIsValid(true);
            if (inputLst.get(0) != null && !inputLst.get(0).trim().equals("") && !inputLst.get(0).trim().equals("")) {
                correctList.add(inputLst.get(0));
                for (int i = 1; i < inputLst.size(); i++) {
                    if (!inputLst.get(i).trim().equals("")) {
                        String prevWord = inputLst.get(i - 1);
                        String word = inputLst.get(i);
                        if (word.toLowerCase().charAt(0) == prevWord.toLowerCase().charAt(prevWord.length() - 1)) {
                            correctList.add(word);
                        } else {
                            game.setGameIsValid(false);
                            break;
                        }
                    } else {
                        game.setGameIsValid(false);
                        break;
                    }
                }

            }
        }
        Map<String, List<String>> gameWords = new LinkedHashMap<>();
        gameWords.put("words", correctList);
        game.setWords(gameWords);
        return game;
    }
}
