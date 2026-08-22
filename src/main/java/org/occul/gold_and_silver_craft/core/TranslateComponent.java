package org.occul.gold_and_silver_craft.core;

public class TranslateComponent {
    private String registerName;
    private String zhCnName;
    private String enUsName;
    public TranslateComponent(String registerName) {
        this.registerName = registerName;
    }
    public TranslateComponent() {}
    public TranslateComponent setEnUsName(String enUsName) {
        this.enUsName = enUsName;
        return this;
    }
    public TranslateComponent setZhCnName(String zhCnName) {
        this.zhCnName = zhCnName;
        return this;
    }
    public TranslateComponent setRegisterName(String registerName) {
        this.registerName = registerName;
        return this;
    }

    public String getRegisterName() {
        return registerName;
    }
    public String getZhCnName() {
        return zhCnName;
    }
    public String getEnUsName() {
        return enUsName;
    }
}
