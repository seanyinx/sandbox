package com.oneapm.tps.agent.service.domain;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SqlTraceDataEntityReflectionTest {
    private final Map<String, String> expectedFields = new HashMap<String, String>() {
        {
            put("sql_trace_id", "bigint");
            put("blame_metric_name", "varchar");
            put("uri", "varchar");
            put("sql_id", "bigint");
            put("metric_name", "varchar");
            put("call_count", "int");
            put("min_time", "float");
            put("max_time", "float");
            put("application_id", "bigint");
            put("parameters", "varchar");
            put("total_time", "float");
            put("avg_time", "float");
            put("sql_info", "varchar");
            put("record_time", "bigint");
            put("agent_run_id", "bigint");
            put("user_id", "bigint");
        }
    };

    private final Map<String, String> types = new HashMap<String, String>() {{
        put("long", "bigint");
        put("int", "int");
        put("float", "float");
        put("class java.lang.String", "varchar");
    }};

    @Test
    public void dataSourceHasExpectedFields() throws ClassNotFoundException {
        Class<?> dataSourceEntity = Class.forName("com.oneapm.tps.agent.service.domain.SqltraceDataEntity");

        List<String> actualFieldNames = new ArrayList<>();
        Map<String, String> actualFields = new HashMap<>();
        for (Field field : dataSourceEntity.getDeclaredFields()) {
            String nameWithUnderscore = LOWER_CAMEL.to(LOWER_UNDERSCORE, field.getName());
            actualFieldNames.add(nameWithUnderscore);
            actualFields.put(nameWithUnderscore, types.get(field.getType().toString()));

            assertThat(field.getModifiers(), is(Modifier.PRIVATE));
        }

        List<String> expectedNames = new ArrayList<>(expectedFields.keySet());
        Collections.sort(expectedNames);
        Collections.sort(actualFieldNames);

        assertArrayEquals(expectedNames.toArray(), actualFieldNames.toArray());

        for (String fieldName : expectedFields.keySet()) {
            assertThat(actualFields.containsKey(fieldName), is(true));

            assertThat(
                    String.format("field type of %s", fieldName),
                    actualFields.get(fieldName),
                    is(expectedFields.get(fieldName)));
        }
    }
}
