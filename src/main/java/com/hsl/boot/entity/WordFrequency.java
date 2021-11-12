package com.hsl.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WordFrequency implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单词id
     */
    private Integer wordId;

    /**
     * 句子id
     */
    private Integer sentenceId;

    /**
     * 课本id
     */
    private Integer bookId;

    /**
     * 单词
     */
    private String content;


}
