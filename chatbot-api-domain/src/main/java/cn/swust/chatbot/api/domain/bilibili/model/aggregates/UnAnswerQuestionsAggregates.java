package cn.swust.chatbot.api.domain.bilibili.model.aggregates;

import cn.swust.chatbot.api.domain.bilibili.model.res.ResData;

/**
 * 未回答问题的聚合信息
 */
public class UnAnswerQuestionsAggregates {
    private String code;
    private String message;
    private String ttl;
    private ResData data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public ResData getData() {
        return data;
    }

    public void setData(ResData data) {
        this.data = data;
    }
}
