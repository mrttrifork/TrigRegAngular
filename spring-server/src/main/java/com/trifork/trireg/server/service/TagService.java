package com.trifork.trireg.server.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.httpClient.TriforkTagHttpClient;
import com.trifork.trireg.server.model.TimeRegistrationTag;
import com.trifork.trireg.server.util.CopyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service()
public class TagService {

    private final Logger logger = LogManager.getLogger(TagService.class);

    final TriforkTagHttpClient client;

    public TagService(@Autowired TriforkTagHttpClient client) {
        this.client = client;
    }

    public List<TimeRegistrationTag> getTimeRegistrationTags(Long timeRegistrationId) {
        try {
            List<com.trifork.trireg.client.api.TimeRegistrationTag> response = client.getTimeRegistrationTags(timeRegistrationId);
            return CopyUtil.transferToTarget(response, new TypeReference<>() {
            });
        } catch (ApiException e) {
            logger.warn("Got an ApiException", e);
            throw new HttpServerErrorException(HttpStatus.resolve(e.getCode()), e.getResponseBody());
        }

    }
}
