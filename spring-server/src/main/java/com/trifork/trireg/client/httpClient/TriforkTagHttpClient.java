package com.trifork.trireg.client.httpClient;

import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.api.TagApi;
import com.trifork.trireg.client.api.TimeRegistrationTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TriforkTagHttpClient {

    private final TagApi tagApi;

    public TriforkTagHttpClient(@Autowired TagApi tagApi) {
        this.tagApi = tagApi;
    }

    public List<TimeRegistrationTag> getTimeRegistrationTags(Long timeRegistrationId) throws ApiException {
        return tagApi.getTimeRegistrationTags(timeRegistrationId);
    }
}
