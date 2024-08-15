package com.trifork.trireg.server.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.api.PeriodEnum;
import com.trifork.trireg.server.model.TimeRegistrationRequest;
import com.trifork.trireg.client.httpClient.TriforkRegistrationHttpClient;
import com.trifork.trireg.server.model.TimeRegistrationResponse;
import com.trifork.trireg.server.model.TimeRegistrationsByTaskResponseInner;
import com.trifork.trireg.server.util.CopyUtil;
import jakarta.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.util.List;

@Service()
public class TimeRegistrationService {

    private final Logger logger = LogManager.getLogger(TimeRegistrationService.class);

    final TriforkRegistrationHttpClient client;

    public TimeRegistrationService(@Autowired TriforkRegistrationHttpClient client) {
        this.client = client;
    }

    public List<TimeRegistrationResponse> getTimeRegistrationsForUser() {
        try {
            List<com.trifork.trireg.client.api.TimeRegistrationResponse> response = client.getTimeRegistrationsForUser();
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error happened while calling getTimeRegistrationsForUser");
        }
    }

    public List<TimeRegistrationsByTaskResponseInner> getTaskTimeRegistrationsOverview(LocalDate date, @Nullable PeriodEnum period) {
        try {
            List<com.trifork.trireg.client.api.TimeRegistrationsByTaskResponseInner> response = client.getTaskTimeRegistrationsOverview(date, period);
            logger.info(response.toString());
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error happened while calling getTimeRegistrationsForUser");
        }
    }

    public String addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) {
        try {
            com.trifork.trireg.client.api.TimeRegistrationRequest clientRequest = CopyUtil.transferToTarget(timeRegistrationRequest, new TypeReference<>() {
            });
            return client.addTimeRegistrationForUser(clientRequest);
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error happened while calling getTimeRegistrationsForUser");
        }
    }
}
