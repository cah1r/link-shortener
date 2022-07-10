package pl.sii.linkshortener.link;

import lombok.*;
import pl.sii.linkshortener.link.api.LinkDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity {
    @Id
    private String id;
    private String email;
    private String targetUrl;
    private LocalDate expirationDate;
    int visits;

    public static LinkEntity fromDto(LinkDto linkDto) {
        return new LinkEntity(
                linkDto.getId(),
                linkDto.getEmail(),
                linkDto.getTargetUrl(),
                linkDto.getExpirationDate(),
                linkDto.getVisits());
    }

    public LinkDto toDto() {
        return LinkDto
                .builder()
                .id(id)
                .email(email)
                .expirationDate(expirationDate)
                .targetUrl(targetUrl)
                .visits(visits)
                .build();
    }
}
