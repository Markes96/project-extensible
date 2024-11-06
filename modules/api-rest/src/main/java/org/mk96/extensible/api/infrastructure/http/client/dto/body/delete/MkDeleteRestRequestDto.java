package org.mk96.extensible.api.infrastructure.http.client.dto.body.delete;
import org.mk96.extensible.api.infrastructure.http.client.dto.body.MkBodyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkDeleteRestRequestDto extends MkBodyRestRequestDto {

    public MkDeleteRestRequestDto(String path) {
        super(HttpMethod.DELETE, path);
    }

    public MkDeleteRestRequestDto(String... pathFragment) {
        super(HttpMethod.DELETE, pathFragment);
    }

}
