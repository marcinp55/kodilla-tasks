package com.crud.tasks.domain;

import org.junit.Assert;
import org.junit.Test;

public class TrelloBadgeDtoTestSuite {
    @Test
    public void shouldFetchTrelloBadgeDtoData() {
        TrelloDto trelloDtoEmpty = new TrelloDto();
        TrelloAttachmentByTypeDto trelloAttachmentByTypeDtoEmpty = new TrelloAttachmentByTypeDto();
        TrelloBadgeDto trelloBadgeDtoEmpty = new TrelloBadgeDto();

        //Given
        TrelloDto trelloDto = new TrelloDto(1, 3);
        TrelloAttachmentByTypeDto trelloAttachmentByTypeDto = new TrelloAttachmentByTypeDto(trelloDto);
        TrelloBadgeDto trelloBadgeDto = new TrelloBadgeDto(5, trelloAttachmentByTypeDto);

        //When
        int votes = trelloBadgeDto.getVotes();
        int board = trelloBadgeDto.getAttachments().getTrello().getBoard();
        int card = trelloBadgeDto.getAttachments().getTrello().getCard();

        //Then
        Assert.assertEquals(5, votes);
        Assert.assertEquals(1, board);
        Assert.assertEquals(3, card);
    }
}
