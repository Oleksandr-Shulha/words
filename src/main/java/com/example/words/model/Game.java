package com.example.words.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Game {
    private Map<String, List<String>> words;
    private boolean gameIsValid;
}
