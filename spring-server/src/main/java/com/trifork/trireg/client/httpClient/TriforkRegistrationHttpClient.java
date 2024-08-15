package com.trifork.trireg.client.httpClient;

import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.api.*;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public List<TimeRegistrationsByTaskResponseInner> getTaskTimeRegistrationsOverview(LocalDate date, @Nullable PeriodEnum period) throws ApiException {
        return timeRegistrationApi.getTaskTimeRegistrationsOverview(date, period);
    }

    public String addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) throws ApiException {
        return timeRegistrationApi.addTimeRegistrationForUser(timeRegistrationRequest);
    }
}
