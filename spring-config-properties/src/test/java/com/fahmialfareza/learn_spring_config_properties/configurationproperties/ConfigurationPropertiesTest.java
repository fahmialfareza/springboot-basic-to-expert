package com.fahmialfareza.learn_spring_config_properties.configurationproperties;

import com.fahmialfareza.learn_spring_config_properties.converter.StringToDateConverter;
import com.fahmialfareza.learn_spring_config_properties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void testConversionService() {
        Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));

        Duration result = conversionService.convert("10s", Duration.class);
        Assertions.assertEquals(Duration.ofSeconds(10), result);
    }

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("learn-spring-config-properties", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertEquals(false, applicationProperties.getProductionMode());
    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("jdbc:postgres://localhost:5432", applicationProperties.getDatabase().getUrl());
        Assertions.assertEquals("reza", applicationProperties.getDatabase().getUsername());
        Assertions.assertEquals("secret", applicationProperties.getDatabase().getPassword());
        Assertions.assertEquals("learn_spring_config_properties", applicationProperties.getDatabase().getDatabase());
    }

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("categories"));
    }

    @Test
    void testEmbeddedCollection() {
        Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());
        Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", applicationProperties.getRoles().get("finance").getName());
    }

    @Test
    void testDuration() {
        Assertions.assertEquals(10, applicationProperties.getDefaultTimeout().getSeconds());
    }

    @Test
    void customConverter() {
        Date expiredDate = applicationProperties.getExpiredDate();

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals("2025-07-28", dateFormat.format(expiredDate));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    @Import({StringToDateConverter.class})
    public static class TestApplication {

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return conversionService;
        }
    }
}
