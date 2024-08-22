package com.trifork.trireg.server.controller;

import com.trifork.trireg.client.api.OverviewPeriod;
import com.trifork.trireg.server.api.TimeRegistrationApi;
import com.trifork.trireg.server.model.*;
import com.trifork.trireg.server.service.TimeRegistrationService;
import com.trifork.trireg.server.util.HTTPResponseUtil;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TimeRegistrationController implements TimeRegistrationApi {

    private final TimeRegistrationService service;

    public TimeRegistrationController(@Autowired TimeRegistrationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<TimeRegistrationResponse>> getTimeRegistrationsForUser() {
        List<TimeRegistrationResponse> timeRegistrationsForUser = service.getTimeRegistrationsForUser();
        if (timeRegistrationsForUser != null) {
            return HTTPResponseUtil.createOKResponse(timeRegistrationsForUser);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }

    @Override
    public ResponseEntity<TimeRegistrationsByTaskResponse> getTaskTimeRegistrationsOverview(LocalDate date, com.trifork.trireg.server.model.OverviewPeriod period, List<Long> extraTasks) {
        OverviewPeriod periodEnum = period != null ? OverviewPeriod.fromValue(period.getValue()) : null;
        TimeRegistrationsByTaskResponse taskTimeRegistrationsOverview = service.getTaskTimeRegistrationsOverview(date, periodEnum, extraTasks);
        if (taskTimeRegistrationsOverview != null) {
            return HTTPResponseUtil.createOKResponse(taskTimeRegistrationsOverview);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find active tasks for user");
    }

    @Override
    public ResponseEntity<DefaultCreateResponse> addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) {
        DefaultCreateResponse response = service.addTimeRegistrationForUser(timeRegistrationRequest);
        if (response != null) {
            return HTTPResponseUtil.createOKResponse(response);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }

    @Override
    public ResponseEntity<DefaultCreateResponse> updateTimeRegistrationForUser(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) {
        DefaultCreateResponse response = service.updateTimeRegistrationForUser(timeRegistrationId, timeRegistrationUpdateRequest);
        if (response != null) {
            return HTTPResponseUtil.createOKResponse(response);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }

    @Override
    public ResponseEntity<DefaultDeleteResponse> deleteTimeRegistration(Long timeRegistrationId) {
        DefaultDeleteResponse response = service.deleteTimeRegistration(timeRegistrationId);
        if (response != null) {
            return HTTPResponseUtil.createOKResponse(response);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }
}
