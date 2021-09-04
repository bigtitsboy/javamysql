package com.etc.dao;

import java.util.ArrayList;

public interface detaildao {
    public ArrayList alldetail();
    public void del(int id);
    public void add(int id,String uname,String userPass);
    public void update(int id,String uname,String userPass,int oldid);
    public ArrayList likeselect(String str);
}
