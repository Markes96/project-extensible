package org.mk96.extensible.api.infrastructure.http.client;

import org.mk96.extensible.api.infrastructure.http.client.dto.MkRestRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface RestClient {

    final RestTemplate CLIENT = new RestTemplate();

    default <R extends MkRestResponseDto> ResponseEntity<R> exchange(
            MkRestRequestDto request,
            Class<R> responseType) {

        return CLIENT.exchange(
        		request.getUri(),
        		request.getMethod(),
        		request.getEntity(),
                responseType);
    }

}
