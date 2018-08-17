package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTestSuite {
    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();

        TrelloList trelloList1 = new TrelloList("1", "List1", true);
        TrelloList trelloList2 = new TrelloList("2", "List2", false);
        TrelloList trelloList3 = new TrelloList("3", "List3", false);
        TrelloList trelloList4 = new TrelloList("4", "List4", true);
        TrelloList trelloList5 = new TrelloList("5", "List5", false);
        TrelloList trelloList6 = new TrelloList("6", "List6", true);

        List<TrelloList> list1 = new ArrayList<>();
        List<TrelloList> list2 = new ArrayList<>();
        List<TrelloList> list3 = new ArrayList<>();
        List<TrelloList> list4 = new ArrayList<>();

        list1.add(trelloList1);
        list1.add(trelloList3);
        list1.add(trelloList6);
        list2.add(trelloList2);
        list2.add(trelloList4);
        list2.add(trelloList6);
        list3.add(trelloList1);
        list3.add(trelloList2);
        list3.add(trelloList3);
        list3.add(trelloList4);
        list4.add(trelloList6);
        list4.add(trelloList5);
        list4.add(trelloList4);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Board1", list1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test", list2);
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "Board2", list3);
        TrelloBoard trelloBoard4 = new TrelloBoard("4", "test", list4);

        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);
        trelloBoards.add(trelloBoard4);

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        Assert.assertEquals(2, filteredBoards.size());
    }
}
