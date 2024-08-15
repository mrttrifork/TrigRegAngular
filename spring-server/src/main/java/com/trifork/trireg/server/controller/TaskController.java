package com.trifork.trireg.server.controller;

import com.trifork.trireg.server.api.TaskApi;
import com.trifork.trireg.server.model.TaskCreateResponseInner;
import com.trifork.trireg.server.service.TaskService;
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
public class TaskController implements TaskApi {

    private final TaskService service;

    public TaskController(@Autowired TaskService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<TaskCreateResponseInner>> getTasksForUser(Long userId) {
        List<TaskCreateResponseInner> timeRegistrationTags = service.getTasksForUser(userId);
        if (timeRegistrationTags != null) {
            return HTTPResponseUtil.createOKResponse(timeRegistrationTags);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Did not find a registration for the user");
    }
}
