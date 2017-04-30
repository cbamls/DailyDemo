package com.cbam.demo.hrbust;

/**
 * Created by Chris on 2017/3/29.
 */

public class ForumService implements ForumServiceInterface{

    private ForumDao forumDao = new ForumDao();
    private TopicDao topicDao = new TopicDao();

    @Override
    public void createForum() {
        this.forumDao.create();
    }

    @Override
    public void removeTopic(String topic) throws Throwable{
        this.topicDao.remove(topic);

        // 此处抛出异常会阻止后置增强执行，触发异常增强执行
        //throw new Exception("thrown from removeTopic");
    }
}
