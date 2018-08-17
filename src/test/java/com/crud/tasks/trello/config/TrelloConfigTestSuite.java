package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void shouldFetchTrelloConfigData() {
        //Given
        //When
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        String trelloAppKey = trelloConfig.getTrelloAppKey();
        String trelloToken = trelloConfig.getTrelloToken();
        String trelloUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
        assertEquals("e4b3af27b066688b61d41b157c75fef4", trelloAppKey);
        assertEquals("8ff5a4e850cbd02da8a147f8dc3b664972efe2174c05e154661704116016d5c3", trelloToken);
        assertEquals("marcin95522311", trelloUsername);
    }
}
