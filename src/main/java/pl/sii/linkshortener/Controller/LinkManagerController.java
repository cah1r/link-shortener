package pl.sii.linkshortener.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sii.linkshortener.LinkService;

@RestController
@RequestMapping("/links")
public class LinkManagerController {
    private final LinkService linkService;
    public LinkManagerController(LinkService linkService) {
        this.linkService = linkService;
    }
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }

}
