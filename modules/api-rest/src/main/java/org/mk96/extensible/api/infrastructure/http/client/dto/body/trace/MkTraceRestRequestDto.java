package org.mk96.extensible.api.infrastructure.http.client.dto.body.trace;
import org.mk96.extensible.api.infrastructure.http.client.dto.body.MkBodyRestRequestDto;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public class MkTraceRestRequestDto extends MkBodyRestRequestDto {

    public MkTraceRestRequestDto(String path) {
        super(HttpMethod.TRACE, path);
    }

    public MkTraceRestRequestDto(String... pathFragment) {
        super(HttpMethod.TRACE, pathFragment);
    }

}
