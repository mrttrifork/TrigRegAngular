package com.trifork.trireg.client.httpClient;

import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.api.TaskApi;
import com.trifork.trireg.client.api.TaskCreateResponseInner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TriforkTaskHttpClient {

    private final TaskApi taskApi;

    public TriforkTaskHttpClient(@Autowired TaskApi taskApi) {
        this.taskApi = taskApi;
    }

    public List<TaskCreateResponseInner> getTasksForUser(Long timeRegistrationId) throws ApiException {
        return taskApi.getTasksForUser(timeRegistrationId);
    }
}
