package org.mk96.extensible.api.infrastructure.http.client.dto.body.patch;
import org.mk96.extensible.api.infrastructure.http.client.dto.body.MkBodyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkPatchRestRequestDto extends MkBodyRestRequestDto {

    public MkPatchRestRequestDto(String path) {
        super(HttpMethod.PATCH, path);
    }

    public MkPatchRestRequestDto(String... pathFragment) {
        super(HttpMethod.PATCH, pathFragment);
    }

}
