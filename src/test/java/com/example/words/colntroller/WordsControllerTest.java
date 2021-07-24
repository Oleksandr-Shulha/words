package com.example.words.colntroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItems;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.example.words.WordsApplication;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = WordsApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
class WordsControllerTest {
    private final static String KEY_WORD = "words";
    private final static String JSON_FILE_ONE = "src/test/java/resources/json-test1.json";
    private final static String JSON_FILE_TWO = "src/test/java/resources/json-test2.json";
    private final static String JSON_FILE_THREE = "src/test/java/resources/json-test3.json";

    @SneakyThrows
    String parseJson(String jsonFile) {
        String request = null;
        try {
            request = FileUtils.readFileToString(new File(jsonFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }


    @Autowired
    private MockMvc mockMvc;

    @Test
    void postGameWithValidJson_Ok() throws Exception {
        mockMvc.perform(post("/words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(parseJson(JSON_FILE_ONE)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + KEY_WORD, hasSize(5)))
                .andExpect(jsonPath("$." + KEY_WORD).value(hasItems("fish", "horse", "egg",
                        "goose", "eagle")));
    }

    @Test
    void postGameWithInvalidWord_Ok() throws Exception {
        mockMvc.perform(post("/words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(parseJson(JSON_FILE_TWO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + KEY_WORD, hasSize(2)))
                .andExpect(jsonPath("$." + KEY_WORD).value(hasItems("fish", "horse")));
    }

    @Test
    void postGameWithInvalidWhitespace_Ok() throws Exception {
        mockMvc.perform(post("/words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(parseJson(JSON_FILE_THREE)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + KEY_WORD, hasSize(2)))
                .andExpect(jsonPath("$."+ KEY_WORD).value(hasItems("fish", "horse")));
    }
}