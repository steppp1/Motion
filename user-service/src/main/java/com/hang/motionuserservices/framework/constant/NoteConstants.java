package com.hang.motionuserservices.framework.constant;

import java.util.Map;

public class NoteConstants {
    public static final String MAPPING_TEMPLATE = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"user_id\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"username\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"avatar\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"add_time\": {\n" +
            "        \"type\": \"date\",\n" +
            "        \"format\": \"epoch_millis\"\n" +
            "      },\n" +
            "      \"last_modify_time\": {\n" +
            "        \"type\": \"date\",\n" +
            "        \"format\": \"epoch_millis\"\n" +
            "      },\n" +
            "      \"type\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"title\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"desc\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"video_url\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"liked_count\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"collected_count\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"comment_count\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"share_count\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"image\": {\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"tag_list\": {\n" +
            "        \"type\": \"text\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
