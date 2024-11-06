package org.mk96.extensible.api.infrastructure.http.client.dto.body.put;
import org.mk96.extensible.api.infrastructure.http.client.dto.body.MkBodyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkPutRestRequestDto extends MkBodyRestRequestDto {

    public MkPutRestRequestDto(String path) {
        super(HttpMethod.PUT, path);
    }

    public MkPutRestRequestDto(String... pathFragment) {
        super(HttpMethod.PUT, pathFragment);
    }

}
