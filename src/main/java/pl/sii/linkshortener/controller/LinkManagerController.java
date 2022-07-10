package pl.sii.linkshortener.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sii.linkshortener.link.api.LinkService;
import pl.sii.linkshortener.link.api.LinkDto;

@RestController
@AllArgsConstructor
@RequestMapping("/links")
class LinkManagerController {
    private final LinkService linkService;
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }

}
