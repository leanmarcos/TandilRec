package com.tandilrec.TandilRec.modules.notifications;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private NotificationsService service;

    public NotificationController() {
        this.service = new NotificationsService();
    }

    @GetMapping("/my")
    public static void getNotifications() {
    }
}
