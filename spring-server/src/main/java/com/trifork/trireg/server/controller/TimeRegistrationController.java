package com.trifork.trireg.server.controller;

import com.trifork.trireg.client.api.PeriodEnum;
import com.trifork.trireg.server.api.TimeRegistrationApi;
import com.trifork.trireg.server.model.TimeRegistrationRequest;
import com.trifork.trireg.server.model.TimeRegistrationResponse;
import com.trifork.trireg.server.model.TimeRegistrationsByTaskResponseInner;
import com.trifork.trireg.server.service.TimeRegistrationService;
import com.trifork.trireg.server.util.HTTPResponseUtil;
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
    public ResponseEntity<List<TimeRegistrationsByTaskResponseInner>> getTaskTimeRegistrationsOverview(LocalDate date, com.trifork.trireg.server.model.PeriodEnum period) {
        PeriodEnum periodEnum = period != null ? PeriodEnum.fromValue(period.getValue()) : null;
        List<TimeRegistrationsByTaskResponseInner> taskTimeRegistrationsOverview = service.getTaskTimeRegistrationsOverview(date, periodEnum);
        if (taskTimeRegistrationsOverview != null) {
            return HTTPResponseUtil.createOKResponse(taskTimeRegistrationsOverview);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find active tasks for user");
    }

    @Override
    public ResponseEntity<String> addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) {
        String response = service.addTimeRegistrationForUser(timeRegistrationRequest);
        if (response != null) {
            return HTTPResponseUtil.createOKResponse(response);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }
}
