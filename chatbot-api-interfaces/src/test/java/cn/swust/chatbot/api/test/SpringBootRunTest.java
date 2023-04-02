package cn.swust.chatbot.api.test;

import cn.swust.chatbot.api.domain.bilibili.IBiliBiliApi;
import cn.swust.chatbot.api.domain.bilibili.model.aggregates.UnAnswerQuestionsAggregates;
import cn.swust.chatbot.api.domain.bilibili.model.vo.Replies;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${chatbot-api.old}")
    private String old;
    @Value("${chatbot-api.cookie}")
    private String cookie;
    @Value("${chatbot-api.csrf}")
    private String csrf;

    @Resource
    private IBiliBiliApi biliBiliApi;

    @Test
    public void test_biliBiliApi() throws IOException {
        UnAnswerQuestionsAggregates unAnswerQuestionsAggregates = biliBiliApi.queryUnAnswerQuestionsReplies(old, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnswerQuestionsAggregates));

        List<Replies> replies = unAnswerQuestionsAggregates.getData().getReplies();
        for (Replies reply : replies) {
            String message = reply.getContent().getMessage();
            String rpid = reply.getRpid();
            logger.info("message: {}",message);
            logger.info("replies: {}",reply.getReplies());
            // 回答问题
            if (reply.getReplies() == null){
                String code = biliBiliApi.answer(old, rpid, rpid, cookie, "请等一等", csrf);
                logger.info("回答问题是否成功, code: {}",code);
            }
        }
    }
}
