package cn.swust.chatbot.api.domain.bilibili.model.res;

import cn.swust.chatbot.api.domain.bilibili.model.vo.Replies;

import java.util.List;

public class ResData {
    private List<Replies> replies;

    public List<Replies> getReplies() {
        return replies;
    }

    public void setReplies(List<Replies> replies) {
        this.replies = replies;
    }
}
