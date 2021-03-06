package com.scienjus.smartqq.model;

import cn.ieclipse.smartim.model.impl.AbstractFrom;

public class DiscussFrom extends AbstractFrom {
    
    private DiscussUser gu;
    private DiscussInfo discuss;
    
    public void setDiscussUser(DiscussUser gu) {
        this.gu = gu;
    }
    
    public DiscussUser getDiscussUser() {
        return gu;
    }
    
    public String getName() {
        return getDiscussUser().getName();
    }
    
    public DiscussInfo getDiscuss() {
        return discuss;
    }
    
    public void setDiscuss(DiscussInfo discuss) {
        this.discuss = discuss;
    }
    
    @Override
    public DiscussInfo getContact() {
        return getDiscuss();
    }
    
    @Override
    public DiscussUser getMember() {
        return gu;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", discuss.getName(), gu.getName());
    }
}
