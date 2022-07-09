package pl.sii.linkshortener;

import pl.sii.linkshortener.Controller.LinkDto;

public interface LinkService {

    LinkDto createLink(LinkDto toDto);
    String getLink(String id);
}
