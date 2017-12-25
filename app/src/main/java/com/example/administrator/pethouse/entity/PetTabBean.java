package com.example.administrator.pethouse.entity;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/20
 */

public class PetTabBean {

    /**
     * ret : true
     * desc : [{"typeName":"边境牧羊犬","id":0,"parentTypeCode":"","isUse":0,"typeCode":"2","petPrice":50,"petTypeImage":"uploadImages/c6b2f571b5e9496788acf3ae53462c27/cat.png","parentTypeName":"中型犬"},{"typeName":"藏獒","id":0,"parentTypeCode":"","isUse":0,"typeCode":"3","petPrice":55,"petTypeImage":"uploadImages/c6b2f571b5e9496788acf3ae53462c27/cat.png","parentTypeName":"大型犬"},{"typeName":"吉娃娃","id":0,"parentTypeCode":"","isUse":0,"typeCode":"1","petPrice":40,"petTypeImage":"uploadImages/c6b2f571b5e9496788acf3ae53462c27/cat.png","parentTypeName":"小型犬"}]
     */

    private boolean ret;
    private List<DescBean> desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<DescBean> getDesc() {
        return desc;
    }

    public void setDesc(List<DescBean> desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * typeName : 边境牧羊犬
         * id : 0
         * parentTypeCode :
         * isUse : 0
         * typeCode : 2
         * petPrice : 50
         * petTypeImage : uploadImages/c6b2f571b5e9496788acf3ae53462c27/cat.png
         * parentTypeName : 中型犬
         */

        private String typeName;
        private int id;
        private String parentTypeCode;
        private int isUse;
        private String typeCode;
        private int petPrice;
        private String petTypeImage;
        private String parentTypeName;

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

        public String getParentTypeCode() {
            return parentTypeCode;
        }

        public void setParentTypeCode(String parentTypeCode) {
            this.parentTypeCode = parentTypeCode;
        }

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public int getPetPrice() {
            return petPrice;
        }

        public void setPetPrice(int petPrice) {
            this.petPrice = petPrice;
        }

        public String getPetTypeImage() {
            return petTypeImage;
        }

        public void setPetTypeImage(String petTypeImage) {
            this.petTypeImage = petTypeImage;
        }

        public String getParentTypeName() {
            return parentTypeName;
        }

        public void setParentTypeName(String parentTypeName) {
            this.parentTypeName = parentTypeName;
        }
    }
}
