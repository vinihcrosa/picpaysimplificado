package com.vinihcrosa.picpaysimplificado.services;

import com.vinihcrosa.picpaysimplificado.domain.user.User;
import com.vinihcrosa.picpaysimplificado.dtos.NotificationDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();

        NotificationDTO notificarionRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = this.restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificarionRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            System.out.println("Error on send notification");
            throw new Exception("Error on send notification");
        }
    }
}
