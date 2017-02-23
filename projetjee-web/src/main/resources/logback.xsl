<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE logback>
<logback>

    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{ISO8601,UTC}Z|%-5p%marker|%t|%c{1}|%m%n</pattern>
        </encoder>
    </appender>



    <logger name="hei.tp06">
        <level value="debug" />
    </logger>


    <root>
        <level value="warn" />
        <appender-ref ref="Console" />
    </root>

</logback>
