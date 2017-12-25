package com.example.administrator.pethouse.entity;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/21
 */

public class HomeFamilyItemBean {


    /**
     * ret : true
     * desc : {"fosterImages":[{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":434,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150434.png"},{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":435,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150449.png"},{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":436,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150503.png"}],"fosterGrade":3.6667,"fosterCommentCount":15,"fosterServices":[{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"大型犬","id":0,"isRe":0,"petPrice":"20.00","typeCode":"23c8d60ef10644ee96314c11c4d3f86b"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"中型犬","id":0,"isRe":0,"petPrice":"30.00","typeCode":"fe013d906bae4945a468780a94212ff7"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小型犬","id":0,"isRe":0,"petPrice":"30.00","typeCode":"20706e878a7b4625be0c5460371a6c25"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小宠","id":0,"isRe":0,"petPrice":"50.00","typeCode":"ffd1209b320c4bb382c5bdac4f722cf4"}],"fosterInfo":{"birthday":735408000000,"isUse":0,"coordX":"40.11765","coordY":"116.250639","userPhone":15275519710,"cityId":"北京市","userImage":"http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40","intro":"喜欢养狗","id":0,"state":3,"qq":0,"userSex":1,"address":"北京市昌平区沙河沙阳路18号北京科技职业学院","identify":"97","openEndTime":"2016-06-17 00:00:00.0","identityCard":"210323199503203097","userName":"杨阳","userId":"536e2c7b99204bbb81ad8fa7e6b2860f","identityImage":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150226.png","position":2,"family":"小街爆的家","openBeginTime":"2016-05-10 00:00:00.0"},"fosterOtherServices":[{"isUse":0,"serviceCode":"228973a1c817412e9cd01ea1d2beb12d","servicePicture":"bathe.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"洗澡2","unit":"元/次","isStandard":0,"petTypeName":"中型犬","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"db9aeac40da94985bc2581bd1ea09eb6","servicePicture":"bathe.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"洗澡5","unit":"元/次","isStandard":0,"petTypeName":"小宠","servicePrice":"111.00","id":0},{"isUse":0,"serviceCode":"81bf1bfad764420784c6f31b348081a0","servicePicture":"shuttle.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"接送2","unit":"元/公里","isStandard":0,"petTypeName":"中型犬","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"2bd0c64bb2784f7f9e85d806a10f8644","servicePicture":"shuttle.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"接送4","unit":"元/公里","isStandard":0,"petTypeName":"小宠","servicePrice":"34.00","id":0}]}
     */

    private boolean ret;
    private DescBean desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public DescBean getDesc() {
        return desc;
    }

    public void setDesc(DescBean desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * fosterImages : [{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":434,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150434.png"},{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":435,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150449.png"},{"usersId":"536e2c7b99204bbb81ad8fa7e6b2860f","id":436,"imageUrl":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150503.png"}]
         * fosterGrade : 3.6667
         * fosterCommentCount : 15
         * fosterServices : [{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"大型犬","id":0,"isRe":0,"petPrice":"20.00","typeCode":"23c8d60ef10644ee96314c11c4d3f86b"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"中型犬","id":0,"isRe":0,"petPrice":"30.00","typeCode":"fe013d906bae4945a468780a94212ff7"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小型犬","id":0,"isRe":0,"petPrice":"30.00","typeCode":"20706e878a7b4625be0c5460371a6c25"},{"isUse":0,"parentTypeName":"","petTypeImage":"cat.png","parentTypeCode":"","typeName":"小宠","id":0,"isRe":0,"petPrice":"50.00","typeCode":"ffd1209b320c4bb382c5bdac4f722cf4"}]
         * fosterInfo : {"birthday":735408000000,"isUse":0,"coordX":"40.11765","coordY":"116.250639","userPhone":15275519710,"cityId":"北京市","userImage":"http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40","intro":"喜欢养狗","id":0,"state":3,"qq":0,"userSex":1,"address":"北京市昌平区沙河沙阳路18号北京科技职业学院","identify":"97","openEndTime":"2016-06-17 00:00:00.0","identityCard":"210323199503203097","userName":"杨阳","userId":"536e2c7b99204bbb81ad8fa7e6b2860f","identityImage":"/536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150226.png","position":2,"family":"小街爆的家","openBeginTime":"2016-05-10 00:00:00.0"}
         * fosterOtherServices : [{"isUse":0,"serviceCode":"228973a1c817412e9cd01ea1d2beb12d","servicePicture":"bathe.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"洗澡2","unit":"元/次","isStandard":0,"petTypeName":"中型犬","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"db9aeac40da94985bc2581bd1ea09eb6","servicePicture":"bathe.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"洗澡5","unit":"元/次","isStandard":0,"petTypeName":"小宠","servicePrice":"111.00","id":0},{"isUse":0,"serviceCode":"81bf1bfad764420784c6f31b348081a0","servicePicture":"shuttle.png","petTypeCode":"fe013d906bae4945a468780a94212ff7","serviceName":"接送2","unit":"元/公里","isStandard":0,"petTypeName":"中型犬","servicePrice":"40.00","id":0},{"isUse":0,"serviceCode":"2bd0c64bb2784f7f9e85d806a10f8644","servicePicture":"shuttle.png","petTypeCode":"ffd1209b320c4bb382c5bdac4f722cf4","serviceName":"接送4","unit":"元/公里","isStandard":0,"petTypeName":"小宠","servicePrice":"34.00","id":0}]
         */

        private double fosterGrade;
        private int fosterCommentCount;
        private FosterInfoBean fosterInfo;
        private List<FosterImagesBean> fosterImages;
        private List<FosterServicesBean> fosterServices;
        private List<FosterOtherServicesBean> fosterOtherServices;

        public double getFosterGrade() {
            return fosterGrade;
        }

        public void setFosterGrade(double fosterGrade) {
            this.fosterGrade = fosterGrade;
        }

        public int getFosterCommentCount() {
            return fosterCommentCount;
        }

        public void setFosterCommentCount(int fosterCommentCount) {
            this.fosterCommentCount = fosterCommentCount;
        }

        public FosterInfoBean getFosterInfo() {
            return fosterInfo;
        }

        public void setFosterInfo(FosterInfoBean fosterInfo) {
            this.fosterInfo = fosterInfo;
        }

        public List<FosterImagesBean> getFosterImages() {
            return fosterImages;
        }

        public void setFosterImages(List<FosterImagesBean> fosterImages) {
            this.fosterImages = fosterImages;
        }

        public List<FosterServicesBean> getFosterServices() {
            return fosterServices;
        }

        public void setFosterServices(List<FosterServicesBean> fosterServices) {
            this.fosterServices = fosterServices;
        }

        public List<FosterOtherServicesBean> getFosterOtherServices() {
            return fosterOtherServices;
        }

        public void setFosterOtherServices(List<FosterOtherServicesBean> fosterOtherServices) {
            this.fosterOtherServices = fosterOtherServices;
        }

        public static class FosterInfoBean {
            /**
             * birthday : 735408000000
             * isUse : 0
             * coordX : 40.11765
             * coordY : 116.250639
             * userPhone : 15275519710
             * cityId : 北京市
             * userImage : http://q.qlogo.cn/qqapp/100371282/290BB8E0BEC8DF5989060A6947C3E75D/40
             * intro : 喜欢养狗
             * id : 0
             * state : 3
             * qq : 0
             * userSex : 1
             * address : 北京市昌平区沙河沙阳路18号北京科技职业学院
             * identify : 97
             * openEndTime : 2016-06-17 00:00:00.0
             * identityCard : 210323199503203097
             * userName : 杨阳
             * userId : 536e2c7b99204bbb81ad8fa7e6b2860f
             * identityImage : /536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150226.png
             * position : 2
             * family : 小街爆的家
             * openBeginTime : 2016-05-10 00:00:00.0
             */

            private long birthday;
            private int isUse;
            private String coordX;
            private String coordY;
            private long userPhone;
            private String cityId;
            private String userImage;
            private String intro;
            private int id;
            private int state;
            private int qq;
            private int userSex;
            private String address;
            private String identify;
            private String openEndTime;
            private String identityCard;
            private String userName;
            private String userId;
            private String identityImage;
            private int position;
            private String family;
            private String openBeginTime;

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getCoordX() {
                return coordX;
            }

            public void setCoordX(String coordX) {
                this.coordX = coordX;
            }

            public String getCoordY() {
                return coordY;
            }

            public void setCoordY(String coordY) {
                this.coordY = coordY;
            }

            public long getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(long userPhone) {
                this.userPhone = userPhone;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getUserImage() {
                return userImage;
            }

            public void setUserImage(String userImage) {
                this.userImage = userImage;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getIdentify() {
                return identify;
            }

            public void setIdentify(String identify) {
                this.identify = identify;
            }

            public String getOpenEndTime() {
                return openEndTime;
            }

            public void setOpenEndTime(String openEndTime) {
                this.openEndTime = openEndTime;
            }

            public String getIdentityCard() {
                return identityCard;
            }

            public void setIdentityCard(String identityCard) {
                this.identityCard = identityCard;
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

            public String getIdentityImage() {
                return identityImage;
            }

            public void setIdentityImage(String identityImage) {
                this.identityImage = identityImage;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getFamily() {
                return family;
            }

            public void setFamily(String family) {
                this.family = family;
            }

            public String getOpenBeginTime() {
                return openBeginTime;
            }

            public void setOpenBeginTime(String openBeginTime) {
                this.openBeginTime = openBeginTime;
            }
        }

        public static class FosterImagesBean {
            /**
             * usersId : 536e2c7b99204bbb81ad8fa7e6b2860f
             * id : 434
             * imageUrl : /536e2c7b99204bbb81ad8fa7e6b2860f/IMG_20160422_150434.png
             */

            private String usersId;
            private int id;
            private String imageUrl;

            public String getUsersId() {
                return usersId;
            }

            public void setUsersId(String usersId) {
                this.usersId = usersId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public static class FosterServicesBean {
            /**
             * isUse : 0
             * parentTypeName :
             * petTypeImage : cat.png
             * parentTypeCode :
             * typeName : 大型犬
             * id : 0
             * isRe : 0
             * petPrice : 20.00
             * typeCode : 23c8d60ef10644ee96314c11c4d3f86b
             */

            private int isUse;
            private String parentTypeName;
            private String petTypeImage;
            private String parentTypeCode;
            private String typeName;
            private int id;
            private int isRe;
            private String petPrice;
            private String typeCode;

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getParentTypeName() {
                return parentTypeName;
            }

            public void setParentTypeName(String parentTypeName) {
                this.parentTypeName = parentTypeName;
            }

            public String getPetTypeImage() {
                return petTypeImage;
            }

            public void setPetTypeImage(String petTypeImage) {
                this.petTypeImage = petTypeImage;
            }

            public String getParentTypeCode() {
                return parentTypeCode;
            }

            public void setParentTypeCode(String parentTypeCode) {
                this.parentTypeCode = parentTypeCode;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsRe() {
                return isRe;
            }

            public void setIsRe(int isRe) {
                this.isRe = isRe;
            }

            public String getPetPrice() {
                return petPrice;
            }

            public void setPetPrice(String petPrice) {
                this.petPrice = petPrice;
            }

            public String getTypeCode() {
                return typeCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }
        }

        public static class FosterOtherServicesBean {
            /**
             * isUse : 0
             * serviceCode : 228973a1c817412e9cd01ea1d2beb12d
             * servicePicture : bathe.png
             * petTypeCode : fe013d906bae4945a468780a94212ff7
             * serviceName : 洗澡2
             * unit : 元/次
             * isStandard : 0
             * petTypeName : 中型犬
             * servicePrice : 40.00
             * id : 0
             */

            private int isUse;
            private String serviceCode;
            private String servicePicture;
            private String petTypeCode;
            private String serviceName;
            private String unit;
            private int isStandard;
            private String petTypeName;
            private String servicePrice;
            private int id;

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public String getServiceCode() {
                return serviceCode;
            }

            public void setServiceCode(String serviceCode) {
                this.serviceCode = serviceCode;
            }

            public String getServicePicture() {
                return servicePicture;
            }

            public void setServicePicture(String servicePicture) {
                this.servicePicture = servicePicture;
            }

            public String getPetTypeCode() {
                return petTypeCode;
            }

            public void setPetTypeCode(String petTypeCode) {
                this.petTypeCode = petTypeCode;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getIsStandard() {
                return isStandard;
            }

            public void setIsStandard(int isStandard) {
                this.isStandard = isStandard;
            }

            public String getPetTypeName() {
                return petTypeName;
            }

            public void setPetTypeName(String petTypeName) {
                this.petTypeName = petTypeName;
            }

            public String getServicePrice() {
                return servicePrice;
            }

            public void setServicePrice(String servicePrice) {
                this.servicePrice = servicePrice;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
