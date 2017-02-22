<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE logback>
<configuration>

    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{ISO8601,UTC}Z|%-5p%marker|%t|%c{1}|%m%n</pattern>
        </encoder>
    </appender>



    <logger name="hei.projetJEE">
        <level value="debug" />
    </logger>


    <root>
        <level value="warn" />
        <appender-ref ref="Console" />
    </root>

</configuration>
