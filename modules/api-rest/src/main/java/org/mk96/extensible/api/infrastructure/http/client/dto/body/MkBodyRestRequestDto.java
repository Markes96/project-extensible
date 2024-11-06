package org.mk96.extensible.api.infrastructure.http.client.dto.body;

import org.mk96.extensible.api.infrastructure.http.client.dto.MkRestRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import lombok.Setter;

@Setter
public abstract class MkBodyRestRequestDto extends MkRestRequestDto {

    protected MkRestBodyDto body;

    public MkBodyRestRequestDto(HttpMethod method, String path) {
        super(method, path);
    }

    public MkBodyRestRequestDto(HttpMethod method, String... pathFragment) {
        super(method, pathFragment);
    }

    @Override
    public HttpEntity<MkRestBodyDto> getEntity() {
        return new HttpEntity<>(this.body, super.headers);
    }

}
