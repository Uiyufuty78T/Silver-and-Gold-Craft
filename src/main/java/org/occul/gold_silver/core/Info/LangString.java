package org.occul.gold_silver.core.Info;

public class LangString {
    private String en_us;
    private String zh_cn;

    public LangString() {}
    public LangString(String en_us) {
        this.en_us = en_us;
        this.zh_cn = en_us;
    }
    public LangString(String en_us, String zh_cn) {
        this.en_us = en_us;
        this.zh_cn = zh_cn;
    }
    public String getEn_us() {
        return en_us;
    }
    public String getZh_cn() {
        return zh_cn;
    }
    public LangString setEn_us(String en_us) {
        this.en_us = en_us;
        return this;
    }
    public LangString setZh_cn(String zh_cn) {
        this.zh_cn = zh_cn;
        return this;
    }
}
