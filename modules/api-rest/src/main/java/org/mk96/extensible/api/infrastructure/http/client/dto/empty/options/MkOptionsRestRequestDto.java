package org.mk96.extensible.api.infrastructure.http.client.dto.empty.options;
import org.mk96.extensible.api.infrastructure.http.client.dto.empty.MkEmptyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkOptionsRestRequestDto extends MkEmptyRestRequestDto {

    public MkOptionsRestRequestDto(String path) {
        super(HttpMethod.OPTIONS, path);
    }

    public MkOptionsRestRequestDto(String... pathFragment) {
        super(HttpMethod.OPTIONS, pathFragment);
    }

}
