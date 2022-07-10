package pl.sii.linkshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sii.linkshortener.controller.LinkDto;
import pl.sii.linkshortener.link.LinkService;
import pl.sii.linkshortener.link.LinkServiceImpl;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistsException;

class LinkServiceImplTest {

    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        //Given
        LinkService linkService = new LinkServiceImpl();
        LinkDto linkDto = new LinkDto("some ID", "test@email.com", "https://google.com", null, 0);
        linkService.createLink(linkDto);

        //When
        Assertions.assertThrows(LinkAlreadyExistsException.class, ()-> linkService.createLink(new LinkDto(
                                                                                                "some ID",
                                                                                                "email@test.pl",
                                                                                                "https://bing.com",
                                                                                                null,
                                                                                                1)));
    }
}