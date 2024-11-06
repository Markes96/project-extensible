package org.mk96.extensible.api.infrastructure.http.client.dto.empty.get;
import org.mk96.extensible.api.infrastructure.http.client.dto.empty.MkEmptyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkGetRestRequestDto extends MkEmptyRestRequestDto {

    public MkGetRestRequestDto(String path) {
        super(HttpMethod.GET, path);
    }

    public MkGetRestRequestDto(String... pathFragment) {
        super(HttpMethod.GET, pathFragment);
    }

}
