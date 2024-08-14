package com.trifork.trireg.client.httpClient;

import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.api.TimeRegistrationApi;
import com.trifork.trireg.client.api.TimeRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TriforkRegistrationHttpClient {

    private final TimeRegistrationApi timeRegistrationApi;

    public TriforkRegistrationHttpClient(@Autowired TimeRegistrationApi timeRegistrationApi) {
        this.timeRegistrationApi = timeRegistrationApi;
    }

    public List<TimeRegistrationResponse> getTimeRegistrationsForUser() throws ApiException {
        return timeRegistrationApi.getTimeRegistrationsForUser();
    }
}
