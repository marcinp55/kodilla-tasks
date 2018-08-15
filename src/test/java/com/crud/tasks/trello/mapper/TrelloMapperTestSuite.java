package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {
    private TrelloMapper mapper = new TrelloMapper();

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        List<TrelloListDto> listDtos = new ArrayList<>();

        listDtos.add(new TrelloListDto("1", "List1", false));
        listDtos.add(new TrelloListDto("2", "List2", false));
        listDtos.add(new TrelloListDto("3", "List3", true));
        listDtos.add(new TrelloListDto("4", "List4", true));

        boardDtos.add(new TrelloBoardDto("1", "Board1", listDtos));
        boardDtos.add(new TrelloBoardDto("2", "Board2", listDtos));

        //When
        List<TrelloBoard> mappedList = mapper.mapToBoards(boardDtos);

        //Then
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "Board1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getName(), "List1");

        Assert.assertEquals(mappedList.get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getName(), "Board2");
        Assert.assertEquals(mappedList.get(1).getLists().get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getLists().get(1).getName(), "List2");
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> boards = new ArrayList<>();
        List<TrelloList> lists = new ArrayList<>();

        lists.add(new TrelloList("1", "List1", false));
        lists.add(new TrelloList("2", "List2", false));
        lists.add(new TrelloList("3", "List3", true));
        lists.add(new TrelloList("4", "List4", true));

        boards.add(new TrelloBoard("1", "Board1", lists));
        boards.add(new TrelloBoard("2", "Board2", lists));

        //When
        List<TrelloBoardDto> mappedList = mapper.mapToBoardsDto(boards);

        //Then
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "Board1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getName(), "List1");

        Assert.assertEquals(mappedList.get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getName(), "Board2");
        Assert.assertEquals(mappedList.get(1).getLists().get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getLists().get(1).getName(), "List2");
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();

        listDtos.add(new TrelloListDto("1", "List1", true));
        listDtos.add(new TrelloListDto("2", "List2", false));

        //When
        List<TrelloList> mappedList = mapper.mapToList(listDtos);

        //Then
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "List1");
        Assert.assertTrue(mappedList.get(0).isClosed());

        Assert.assertEquals(mappedList.get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getName(), "List2");
        Assert.assertFalse(mappedList.get(1).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> lists = new ArrayList<>();

        lists.add(new TrelloList("1", "List1", true));
        lists.add(new TrelloList("2", "List2", false));

        //When
        List<TrelloListDto> mappedList = mapper.mapToListDto(lists);

        //Then
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "List1");
        Assert.assertTrue(mappedList.get(0).isClosed());

        Assert.assertEquals(mappedList.get(1).getId(), "2");
        Assert.assertEquals(mappedList.get(1).getName(), "List2");
        Assert.assertFalse(mappedList.get(1).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card1", "Card 1 description", "Top", "1");
        TrelloCardDto trelloCardDto2 = new TrelloCardDto("Card2", "Card 2 description", "Bottom", "2");

        //When
        TrelloCard trelloCard1 = mapper.mapToCard(trelloCardDto1);
        TrelloCard trelloCard2 = mapper.mapToCard(trelloCardDto2);

        //Then
        Assert.assertEquals(trelloCard1.getName(), "Card1");
        Assert.assertEquals(trelloCard1.getDescription(), "Card 1 description");
        Assert.assertEquals(trelloCard1.getPos(), "Top");
        Assert.assertEquals(trelloCard1.getListId(), "1");

        Assert.assertEquals(trelloCard2.getName(), "Card2");
        Assert.assertEquals(trelloCard2.getDescription(), "Card 2 description");
        Assert.assertEquals(trelloCard2.getPos(), "Bottom");
        Assert.assertEquals(trelloCard2.getListId(), "2");
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("Card1", "Card 1 description", "Top", "1");
        TrelloCard trelloCard2 = new TrelloCard("Card2", "Card 2 description", "Bottom", "2");

        //When
        TrelloCardDto trelloCardDto1 = mapper.mapToCardDto(trelloCard1);
        TrelloCardDto trelloCardDto2 = mapper.mapToCardDto(trelloCard2);

        //Then
        Assert.assertEquals(trelloCardDto1.getName(), "Card1");
        Assert.assertEquals(trelloCardDto1.getDescription(), "Card 1 description");
        Assert.assertEquals(trelloCardDto1.getPos(), "Top");
        Assert.assertEquals(trelloCardDto1.getListId(), "1");

        Assert.assertEquals(trelloCardDto2.getName(), "Card2");
        Assert.assertEquals(trelloCardDto2.getDescription(), "Card 2 description");
        Assert.assertEquals(trelloCardDto2.getPos(), "Bottom");
        Assert.assertEquals(trelloCardDto2.getListId(), "2");
    }
}
