package org.mk96.extensible.api.infrastructure.http.client.dto.empty.head;
import org.mk96.extensible.api.infrastructure.http.client.dto.empty.MkEmptyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkHeadRestRequestDto extends MkEmptyRestRequestDto {

    public MkHeadRestRequestDto(String path) {
        super(HttpMethod.HEAD, path);
    }

    public MkHeadRestRequestDto(String... pathFragment) {
        super(HttpMethod.HEAD, pathFragment);
    }

}
