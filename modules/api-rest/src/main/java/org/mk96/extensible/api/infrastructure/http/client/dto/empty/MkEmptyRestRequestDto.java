package org.mk96.extensible.api.infrastructure.http.client.dto.empty;

import org.mk96.extensible.api.infrastructure.http.client.dto.MkRestRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

public abstract class MkEmptyRestRequestDto extends MkRestRequestDto {

    public MkEmptyRestRequestDto(HttpMethod method, String path) {
        super(method, path);
    }

    public MkEmptyRestRequestDto(HttpMethod method, String... pathFragment) {
        super(method, pathFragment);
    }

    @Override
    public HttpEntity<MkRestBodyDto> getEntity() {
        return new HttpEntity<>(super.headers);
    }

}
