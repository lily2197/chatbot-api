package cn.swust.chatbot.api.domain.bilibili;

import cn.swust.chatbot.api.domain.bilibili.model.aggregates.UnAnswerQuestionsAggregates;

import java.io.IOException;

/**
 * BiliBili API 接口
 */
public interface IBiliBiliApi {
    /**
     * @param old 视频或文章av号
     */
    UnAnswerQuestionsAggregates queryUnAnswerQuestionsReplies(String old,String cookie) throws IOException;

    String answer(String old,String root,String parent,String cookie,String message,String csrf) throws IOException;
}
