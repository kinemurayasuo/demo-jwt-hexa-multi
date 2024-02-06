package com.example.common.utils.time;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public final class ServerTime {
    public final ZoneId zoneId;

    public ServerTime(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public OffsetDateTime now() {return OffsetDateTime.now(zoneId);}

    public LocalDateTime nowLocal() {return now().toLocalDateTime();}
}
