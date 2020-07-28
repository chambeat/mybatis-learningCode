package com.chm.domain;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;

    }
}
