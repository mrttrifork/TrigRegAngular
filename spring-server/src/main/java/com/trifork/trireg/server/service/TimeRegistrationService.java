package com.trifork.trireg.server.service;

import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.httpClient.TriforkRegistrationHttpClient;
import com.trifork.trireg.server.model.TimeRegistrationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service()
public class TimeRegistrationService {

    private final Logger logger = LogManager.getLogger(TimeRegistrationService.class);

    final TriforkRegistrationHttpClient client;

    public TimeRegistrationService(@Autowired TriforkRegistrationHttpClient client) {
        this.client = client;
    }

    public List<TimeRegistrationResponse> getTimeRegistrationsForUser() {
        try {
            List<com.trifork.trireg.client.api.TimeRegistrationResponse> timeRegistrationsForUser = client.getTimeRegistrationsForUser();
            ArrayList<TimeRegistrationResponse> timeRegistrationResponses = new ArrayList<>();
            BeanUtils.copyProperties(timeRegistrationsForUser, timeRegistrationResponses);
            return timeRegistrationResponses;
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error happened while calling getTimeRegistrationsForUser");
        }

    }
}
