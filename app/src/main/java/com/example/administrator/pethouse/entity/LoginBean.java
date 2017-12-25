package com.example.administrator.pethouse.entity;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class LoginBean {
    /**
     * ret : true
     * result : {"isUse":0,"userPhone":13167582014,"password":"123456","id":0,"state":0,"qq":0,"userSex":1,"userName":"osg855","userId":"9a5645cb3f9e4c5e87a7f87e889ababb","position":1}
     */

    private boolean ret;
    private ResultBean result;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * isUse : 0
         * userPhone : 13167582014
         * password : 123456
         * id : 0
         * state : 0
         * qq : 0
         * userSex : 1
         * userName : osg855
         * userId : 9a5645cb3f9e4c5e87a7f87e889ababb
         * position : 1
         */

        private int isUse;
        private long userPhone;
        private String password;
        private int id;
        private int state;
        private int qq;
        private int userSex;
        private String userName;
        private String userId;
        private int position;

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public long getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(long userPhone) {
            this.userPhone = userPhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getQq() {
            return qq;
        }

        public void setQq(int qq) {
            this.qq = qq;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
