package com.example.words.colntroller;

import com.example.words.service.WordsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(WordsController.class)
public class WordsControllerTest {

    @Autowired MockMvc mvc;
    @MockBean
    WordsService wordsService;


}