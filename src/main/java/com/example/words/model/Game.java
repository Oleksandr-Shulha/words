package com.example.words.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Game {
    public Map<String, List<String>> words;
    public boolean gameIsValid;

}
