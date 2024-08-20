package com.trifork.trireg.server.controller;

import com.trifork.trireg.server.api.TagApi;
import com.trifork.trireg.server.model.TimeRegistrationTag;
import com.trifork.trireg.server.service.TagService;
import com.trifork.trireg.server.util.HTTPResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TagController implements TagApi {

    private final TagService service;

    public TagController(@Autowired TagService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<TimeRegistrationTag>> getTimeRegistrationTags(Long timeRegistrationId) {
        List<TimeRegistrationTag> timeRegistrationTags = service.getTimeRegistrationTags(timeRegistrationId);
        if (timeRegistrationTags != null) {
            return HTTPResponseUtil.createOKResponse(timeRegistrationTags);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }
}
