package pl.sii.linkshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sii.linkshortener.link.LinkEntity;
import pl.sii.linkshortener.link.LinkRepository;
import pl.sii.linkshortener.link.api.LinkDto;
import pl.sii.linkshortener.link.LinkServiceImpl;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistsException;
import pl.sii.linkshortener.link.api.exception.LinkNotFoundException;
import java.util.Optional;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {
    @Mock
    LinkRepository repository;
    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        //Given
        LinkDto linkDto = new LinkDto(
                "some ID",
                "test@email.com",
                "https://google.com",
                null,
                0);
        given(repository.findById("some ID")).willReturn(Optional.of(LinkEntity.fromDto(linkDto)));
        //When
        Assertions.assertThrows(LinkAlreadyExistsException.class,
                ()-> linkService.createLink(new LinkDto(
                        "some ID",
                        "email@test.pl",
                        "https://bing.com",
                        null,
                        1)));
    }

    @Test
    void shouldThrowLinkNotFoundExceptionInCaseOfLinkNotFound() {
        //Given
        String id = "test";
        given(repository.findById(id)).willReturn(Optional.empty());
        //Then
        Assertions.assertThrows(LinkNotFoundException.class,
                ()-> linkService.getLink(id));
    }

    @Test
    void shouldIncrementVisitsNumberOnEntry() {
        //Given
        String id = "test";

    }
}