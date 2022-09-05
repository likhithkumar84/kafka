package com.spring.demo;

import com.cronutils.builder.CronBuilder;
import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;
import static com.cronutils.model.field.expression.FieldExpressionFactory.on;

@SpringBootApplication
@Slf4j
public class Demo {
    private static final String TIME = "00:00:00";

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);

        String cubaDateTimeInUtc = getZonedDateTimeInUtc("Cuba", TIME);
        String mexicoDateTimeInUtc = getZonedDateTimeInUtc("Mexico/General", TIME);
        String indiaDateTimeInUtc = getZonedDateTimeInUtc("Asia/Kolkata", TIME);

        log.info("Cuba : {}", cubaDateTimeInUtc);
        log.info("Mexico : {}", mexicoDateTimeInUtc);
        log.info("India : {}", indiaDateTimeInUtc);

        String cronExpression = "0 0 12 ? * * *";
        List<String> cronParams = new ArrayList<>(Arrays.asList(cronExpression.split(" ")));
        cronParams.set(0, String.valueOf(0));
        cronParams.set(1, String.valueOf(30));
        cronParams.set(2, String.valueOf(01));
        cronExpression = String.join(" ", cronParams);
        log.info("cron expression: " + cronExpression);

        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
        CronParser parser = new CronParser(cronDefinition);
        Cron cron = CronBuilder.cron(cronDefinition)
                .withYear(always())
                .withDoW(questionMark())
                .withMonth(on(11))
                .withDoM(on(30))
                .withHour(on(0))
                .withMinute(on(0))
                .withSecond(on(0))
                .instance();

        log.info("Cron -> {}", cron.asString());
        CronDescriptor descriptor = CronDescriptor.instance(Locale.UK);
        String description = descriptor.describe(parser.parse(cron.asString()));
        log.info("Describe Cron -> {}", description);
        Optional<ZonedDateTime> date = ExecutionTime.forCron(cron)
                .nextExecution(ZonedDateTime.now(TimeZone.getTimeZone("Cuba").toZoneId()));
        Instant instant = date.orElseThrow(() -> new DateTimeException("Invalid Time")).toInstant();
        log.info("Instant -> {}", instant.truncatedTo(ChronoUnit.SECONDS));
    }

    private static String getZonedDate(String timeZone) {

        return ZonedDateTime.now(TimeZone.getTimeZone(timeZone).toZoneId()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private static String getZonedDateTimeInUtc(String timeZone, String zonedTime) {

        String formattedDateTime = String.format("%sT%s", getZonedDate(timeZone), zonedTime);
        TemporalAccessor date = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
                .withZone(TimeZone.getTimeZone(timeZone).toZoneId()).parse(formattedDateTime);

        return Instant.from(date).truncatedTo(ChronoUnit.SECONDS).toString();
    }
}
