package pl.sii.linkshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sii.linkshortener.Controller.LinkDto;

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