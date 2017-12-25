package com.example.administrator.pethouse.entity;

/**
 * Created by mMaster
 * on 2017/12/14.
 * at 北京
 */

public class RegisterBean {
    /**
     * ret : true
     * result : {"isUse":0,"userPhone":15167582015,"password":"123456","endIndex":0,"id":0,"state":0,"imageType":0,"qq":0,"userSex":0,"userName":"fjt068","userId":"58b15e0da735425ab4ab20e920a95304","beginIndex":0,"position":0}
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
         * userPhone : 15167582015
         * password : 123456
         * endIndex : 0
         * id : 0
         * state : 0
         * imageType : 0
         * qq : 0
         * userSex : 0
         * userName : fjt068
         * userId : 58b15e0da735425ab4ab20e920a95304
         * beginIndex : 0
         * position : 0
         */

        private int isUse;
        private long userPhone;
        private String password;
        private int endIndex;
        private int id;
        private int state;
        private int imageType;
        private int qq;
        private int userSex;
        private String userName;
        private String userId;
        private int beginIndex;
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

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
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

        public int getImageType() {
            return imageType;
        }

        public void setImageType(int imageType) {
            this.imageType = imageType;
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

        public int getBeginIndex() {
            return beginIndex;
        }

        public void setBeginIndex(int beginIndex) {
            this.beginIndex = beginIndex;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
