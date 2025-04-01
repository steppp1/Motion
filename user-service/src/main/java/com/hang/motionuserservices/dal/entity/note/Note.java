package com.hang.motionuserservices.dal.entity.note;

import lombok.Data;

import java.util.List;

@Data
public class Note {
    private Integer id; // 对应于 Elasticsearch 的 id 字段
    private String userId; // 对应于 user_id
    private String username; // 对应于 username
    private String avatar; // 对应于 avatar
    private Long addTime; // 对应于 add_time
    private Long lastModifyTime; // 对应于 last_modify_time
    private String type; // 对应于 type
    private String title; // 对应于 title
    private String desc; // 对应于 desc
    private String videoUrl; // 对应于 video_url
    private Integer likedCount; // 对应于 liked_count
    private Integer collectedCount; // 对应于 collected_count
    private Integer commentCount; // 对应于 comment_count
    private Integer shareCount; // 对应于 share_count
    private String image; // 对应于 image
    private List<String> tagList; // 对应于 tag_list
}
