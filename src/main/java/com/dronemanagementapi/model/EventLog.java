package com.dronemanagementapi.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class EventLog {
   @Id

   @Column(name = "event_type", columnDefinition = "VARCHAR(100) NOT NULL")
   private String eventType;

   @Column(name = "resource_id", columnDefinition = "INT NOT NULL")
   private int resourceId;

   @Column(name = "event_message", columnDefinition = "TEXT")
   private String eventMessage;

   public EventLog() {
   }

   public EventLog(String eventType, int resourceId, String eventMessage) {
      this.eventType = eventType;
      this.resourceId = resourceId;
      this.eventMessage = eventMessage;
   }

}
