package com.trifork.trireg.server.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.httpClient.TriforkTaskHttpClient;
import com.trifork.trireg.server.model.TaskCreateResponseInner;
import com.trifork.trireg.server.util.CopyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@Service()
public class TaskService {

    private final Logger logger = LogManager.getLogger(TagService.class);

    final TriforkTaskHttpClient client;

    public TaskService(@Autowired TriforkTaskHttpClient client) {
        this.client = client;
    }

    public List<TaskCreateResponseInner> getTasksForUser(Long timeRegistrationId) {
        try {
            List<com.trifork.trireg.client.api.TaskCreateResponseInner> response = client.getTasksForUser(timeRegistrationId);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {});
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error happened while calling getTimeRegistrationsForUser");
        }

    }
}
