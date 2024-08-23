package com.trifork.trireg.server.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.server.model.*;
import com.trifork.trireg.client.api.OverviewPeriod;
import com.trifork.trireg.client.httpClient.TriforkRegistrationHttpClient;
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
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }

    public TimeRegistrationsByTaskResponse getTaskTimeRegistrationsOverview(LocalDate date, @Nullable OverviewPeriod period, @Nullable List<Long> extraTasks) {
        try {
            com.trifork.trireg.client.api.TimeRegistrationsByTaskResponse response = client.getTaskTimeRegistrationsOverview(date, period, extraTasks);
            logger.info(response.toString());
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }

    public DefaultCreateResponse addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) {
        try {
            com.trifork.trireg.client.api.TimeRegistrationRequest clientRequest = CopyUtil.transferToTarget(timeRegistrationRequest, new TypeReference<>() {
            });
            com.trifork.trireg.client.api.DefaultCreateResponse response = client.addTimeRegistrationForUser(clientRequest);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }

    public DefaultCreateResponse updateTimeRegistrationForUser(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) {
        try {
            com.trifork.trireg.client.api.TimeRegistrationUpdateRequest clientRequest = CopyUtil.transferToTarget(timeRegistrationUpdateRequest, new TypeReference<>() {
            });
            com.trifork.trireg.client.api.DefaultCreateResponse response = client.updateTimeRegistrationForUser(timeRegistrationId, clientRequest);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }

    public DefaultDeleteResponse deleteTimeRegistration(Long timeRegistrationId) {
        try {
            com.trifork.trireg.client.api.DefaultDeleteResponse response = client.deleteTimeRegistration(timeRegistrationId);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }

    public DefaultUpdateResponse associateTimeRegistrationWithTask(TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest) {
        try {
            com.trifork.trireg.client.api.TimeRegistrationAssociateTaskRequest clientRequest = CopyUtil.transferToTarget(timeRegistrationAssociateTaskRequest, new TypeReference<>() {
            });
            com.trifork.trireg.client.api.DefaultUpdateResponse response = client.associateTimeRegistrationWithTask(clientRequest);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }
    }
}
