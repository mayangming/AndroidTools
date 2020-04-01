package com.common.tools.model;

/**
 * EventBus事件总线的实体类
 */
public class EventBusModel {
    private int status = 0;//状态,0 网络状态
    private Object content = null;//内容，这个内容根据不同的状态值进行强转

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EventBusModel{" +
                "status=" + status +
                ", content=" + content +
                '}';
    }
}