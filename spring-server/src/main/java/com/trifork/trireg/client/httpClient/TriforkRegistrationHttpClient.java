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

    public TimeRegistrationsByTaskResponse getTaskTimeRegistrationsOverview(LocalDate date, @Nullable OverviewPeriod period, @Nullable List<Long> extraTasks) throws ApiException {
        return timeRegistrationApi.getTaskTimeRegistrationsOverview(date, period, extraTasks);
    }

    public DefaultCreateResponse addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) throws ApiException {
        return timeRegistrationApi.addTimeRegistrationForUser(timeRegistrationRequest);
    }

    public DefaultCreateResponse updateTimeRegistrationForUser(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) throws ApiException {
        return timeRegistrationApi.updateTimeRegistrationForUser(timeRegistrationId, timeRegistrationUpdateRequest);
    }

    public DefaultDeleteResponse deleteTimeRegistration(Long timeRegistrationId) throws ApiException {
        return timeRegistrationApi.deleteTimeRegistration(timeRegistrationId);
    }

    public DefaultUpdateResponse associateTimeRegistrationWithTask(TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest) throws ApiException {
        return timeRegistrationApi.associateTimeRegistrationWithTask(timeRegistrationAssociateTaskRequest);
    }
}
