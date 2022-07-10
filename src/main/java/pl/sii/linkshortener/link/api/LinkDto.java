package pl.sii.linkshortener.link.api;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

public class LinkDto {
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visits;

    public LinkDto(String id,
                   String email,
                   String targetUrl,
                   LocalDate expirationDate,
                   int visits) {

        this.id = id;
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
        this.visits = visits;
    }

    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }

    public String getId() {
        return id;
    }

    public String getTargetUrl() {
        return targetUrl;
    }
}


