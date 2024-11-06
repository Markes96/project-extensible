package org.mk96.extensible.api.infrastructure.http.client.dto.body.post;
import org.mk96.extensible.api.infrastructure.http.client.dto.body.MkBodyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkPostRestRequestDto extends MkBodyRestRequestDto {

    public MkPostRestRequestDto(String path) {
        super(HttpMethod.POST, path);
    }

    public MkPostRestRequestDto(String... pathFragment) {
        super(HttpMethod.POST, pathFragment);
    }

}
