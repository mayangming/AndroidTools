package com.tools.type;

/**
 * 对于枚举变量的示例演示
 */
public class TypeUtilsExample {

    private static TypeUtilsExample mIntanse = new TypeUtilsExample();


    public static TypeUtilsExample getInstance() {
        return mIntanse;
    }

    private TypeUtilsExample() {
    }

    /**
     * 根据枚举值获取该枚举类型
     * @param periodValue
     * @return
     */
    public TypeEnum getTypeEnumByValue(int periodValue){
        TypeEnum periodResult = TypeEnum.TYPE_A;
        for (TypeEnum typeEnum : TypeEnum.values()){
            if (typeEnum.typeValue == periodValue){
                periodResult = typeEnum;
                break;
            }
        }
        return periodResult;
    }

    /**
     * 根据枚举名字获取该枚举类型
     * @param periodName
     * @return
     */
    public TypeEnum getTypeEnumByName(String periodName){
        TypeEnum periodResult = TypeEnum.TYPE_A;
        for (TypeEnum typeEnum : TypeEnum.values()){
            if (typeEnum.typeName.equals(periodName)){
                periodResult = typeEnum;
                break;
            }
        }
        return periodResult;
    }

    /**
     * 根据枚举名字寻找该枚举在所有枚举中的位置
     * @param name
     * @return
     */
    private int findIndexByName(String name){
        int index = 0;
        TypeEnum[] result = TypeEnum.values();
        for (int i = 0; i < result.length; i++){
            TypeEnum interval = result[i];
            if (interval.typeName.equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 根据值寻找该枚举在所有枚举中的位置
     * @param value
     * @return
     */
    private int findIndexByValue(int value){
        int index = 0;
        TypeEnum[] result = TypeEnum.values();
        for (int i = 0; i < result.length; i++){
            TypeEnum interval = result[i];
            if (interval.typeValue == value){
                index = i;
                break;
            }
        }
        return index;
    }
    public enum TypeEnum {

        TYPE_A("a", 1),
        TYPE_B("b", 2),
        TYPE_C("c", 3);

        private String typeName;//类型的名字
        private int typeValue;//类型的值

        TypeEnum(String typeName, int TypeValue) {
            this.typeName = typeName;
            this.typeValue = TypeValue;
        }

        /**
         * 获取当前枚举的名字
         * @return
         */
        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 获取当前枚举的值
         * @return
         */
        public int getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(int typeValue) {
            this.typeValue = typeValue;
        }
    }
}