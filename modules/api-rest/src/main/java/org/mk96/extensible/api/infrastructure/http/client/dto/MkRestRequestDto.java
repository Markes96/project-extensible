package org.mk96.extensible.api.infrastructure.http.client.dto;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mk96.extensible.api.infrastructure.dto.MkDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.Getter;
import lombok.Setter;

@Setter
public abstract class MkRestRequestDto extends MkDto {

    // Entity
    @Getter
    protected final HttpMethod method;
    protected final HttpHeaders headers = new HttpHeaders();

    // URI
    protected final String path;
    protected final Map<String, Object> uriVariables = new HashMap<>();
    protected final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

    // Info
    protected String host;
    protected Integer port;
    protected String userInfo;

    public MkRestRequestDto(HttpMethod method, String path) {
        this.method = method;
        this.path = path;
    }

    public MkRestRequestDto(HttpMethod method, String... pathFragment) {
        this.method = method;
        this.path = String.join("/", pathFragment);
    }

    //////////////////////////////////////////////////////
    /// HEADERS
    //////////////////////////////////////////////////////

    public void addHeader(String key, String value) {
        this.headers.add(key, value);
    }

    public void putHeader(String key, List<String> values) {
        this.headers.put(key, values);
    }

    public void addAllHeaders(MultiValueMap<String, String> headers) {
        this.headers.addAll(headers);
    }

    //////////////////////////////////////////////////////
    /// PATH VARIABLES
    //////////////////////////////////////////////////////

    public void putUriVariables(String key, String value) {
        this.uriVariables.put(key, value);
    }

    public void putAllUriVariables(Map<String, Object> pathVariables) {
        this.uriVariables.putAll(pathVariables);
    }

    //////////////////////////////////////////////////////
    /// QUERY PARAMS
    //////////////////////////////////////////////////////

    public void addQueryParam(String key, String value) {
        this.queryParams.add(key, value);
    }

    public void putQueryParam(String key, List<String> values) {
        this.queryParams.put(key, values);
    }

    public void addAllQueryParam(MultiValueMap<String, String> queryParams) {
        this.queryParams.addAll(queryParams);
    }

    public URI getUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath(this.path);
        uriBuilder = uriBuilder.uriVariables(this.uriVariables);
        uriBuilder = uriBuilder.queryParams(this.queryParams);

        if(port != null) {
            uriBuilder = uriBuilder.port(port);
        }

        if(userInfo != null) {
            uriBuilder = uriBuilder.userInfo(userInfo);
        }

        if(host != null) {
            uriBuilder = uriBuilder.host(host);
        }

        return uriBuilder.build().toUri();
    }

    public abstract HttpEntity<MkRestBodyDto> getEntity();

}
