package com.pigcanfly.translate;

/**
 * @author Tobby Quinn
 * @date 2019/05/07
 */
public enum Lang {

    /**
     * 自动检测
     */
    AUTO("auto", "auto", null, null),
    /**
     * 中文
     */
    CHINESE("chinese", "zh-CN", "zh-CHS", "zh"),
    /**
     * 英语
     */
    ENGLISH("english", "en", null, null),
    /**
     * 中文(繁体)
     */
    CHINESE_TRADITIONAL("chinese.traditional", "zh-TW", null, "cht"),
    /**
     * 文言文
     */
    CHINESE_CLASSICAL("chinese.classical", "zh-CLASSICAL", null, "wyw"),
    /**
     * 粤语
     */
    CHINESE_CANTONESE("chinese.cantonese", "zh-CANTONESE", null, "yue"),
    /**
     * 阿尔巴尼亚语
     */
    ALBANIAN("albanian", "sq", null, null),
    /**
     * 阿拉伯语
     */
    ARABIC("arabic", "ar", null, "ara"),
    /**
     * 阿姆哈拉语
     */
    AMHARIC("amharic", "am", null, null),
    /**
     * 阿塞拜疆语
     */
    AZERBAIJANI("azerbaijani", "az", null, null),
    /**
     * 爱尔兰语
     */
    IRISH("irish", "ga", null, null),
    /**
     * 爱沙尼亚语
     */
    ESTONIAN("estonian", "et", null, "est"),
    /**
     * 巴斯克语
     */
    BASQUE("basque", "eu", null, null),
    /**
     * 白俄罗斯语
     */
    BELARUSIAN("belarusian", "be", null, null),
    /**
     * 保加利亚语
     */
    BULGARIAN("bulgarian", "bg", null, "bul"),
    /**
     * 冰岛语
     */
    ICELANDIC("icelandic", "is", null, null),
    /**
     * 波兰语
     */
    POLISH("polish", "pl", null, null),
    /**
     * 波斯尼亚语
     */
    BOSNIAN("bosnian", "bs", null, null),
    /**
     * 波斯语
     */
    PERSIAN("persian", "fa", null, null),
    /**
     * 布尔语(南非荷兰语)
     */
    AFRIKAANS("afrikaans", "af", null, null),
    /**
     * 丹麦语
     */
    DANISH("danish", "da", null, "dan"),
    /**
     * 德语
     */
    GERMAN("german", "de", null, null),
    /**
     * 俄语
     */
    RUSSIAN("russian", "ru", null, null),
    /**
     * 法语
     */
    FRENCH("french", "fr", null, "fra"),
    /**
     * 菲律宾语
     */
    FILIPINO("filipino", "tl", null, null),
    /**
     * 芬兰语
     */
    FINNISH("finnish", "fi", null, "fin"),
    /**
     * 弗里西语
     */
    FRISIAN("frisian", "fy", null, null),
    /**
     * 高棉语
     */
    KHMER("khmer", "km", null, null),
    /**
     * 格鲁吉亚语
     */
    GEORGIAN("georgian", "ka", null, null),
    /**
     * 古吉拉特语
     */
    GUJARATI("gujarati", "gu", null, null),
    /**
     * 哈萨克语
     */
    KAZAKH("kazakh", "kk", null, null),
    /**
     * 海地克里奥尔语
     */
    HAITIAN_CREOLE("haitianCreole", "ht", null, null),
    /**
     * 韩语
     */
    KOREAN("korean", "ko", null, "kor"),
    /**
     * 豪萨语
     */
    HAUSA("hausa", "ha", null, null),
    /**
     * 荷兰语
     */
    DUTCH("dutch", "nl", null, null),
    /**
     * 吉尔吉斯语
     */
    KYRGYZ("kyrgyz", "ky", null, null),
    /**
     * 加利西亚语
     */
    GALICIAN("galician", "gl", null, null),
    /**
     * 加泰罗尼亚语
     */
    CATALAN("catalan", "ca", null, null),
    /**
     * 捷克语
     */
    CZECH("czech", "cs", null, null),
    /**
     * 卡纳达语
     */
    KANNADA("kannada", "kn", null, null),
    /**
     * 科西嘉语
     */
    CORSICAN("corsican", "co", null, null),
    /**
     * 克罗地亚语
     */
    CROATIAN("croatian", "hr", null, null),
    /**
     * 库尔德语
     */
    KURDISH("kurdish", "ku", null, null),
    /**
     * 拉丁语
     */
    LATIN("latin", "la", null, null),
    /**
     * 拉脱维亚语
     */
    LATVIAN("latvian", "lv", null, null),
    /**
     * 老挝语
     */
    LAO("lao", "lo", null, null),
    /**
     * 立陶宛语
     */
    LITHUANIAN("lithuanian", "lt", null, null),
    /**
     * 卢森堡语
     */
    LUXEMBOURGISH("luxembourgish", "lb", null, null),
    /**
     * 罗马尼亚语
     */
    ROMANIAN("romanian", "ro", null, "rom"),
    /**
     * 马尔加什语
     */
    MALAGASY("malagasy", "mg", null, null),
    /**
     * 马耳他语
     */
    MALTESE("maltese", "mt", null, null),
    /**
     * 马拉地语
     */
    MARATHI("marathi", "mr", null, null),
    /**
     * 马拉雅拉姆语
     */
    MALAYALAM("malayalam", "ml", null, null),
    /**
     * 马来语
     */
    MALAY("malay", "ms", null, null),
    /**
     * 马其顿语
     */
    MACEDONIAN("macedonian", "mk", null, null),
    /**
     * 毛利语
     */
    MAORI("maori", "mi", null, null),
    /**
     * 蒙古语
     */
    MONGOLIAN("mongolian", "mn", null, null),
    /**
     * 孟加拉语
     */
    BENGALI("bengali", "bn", null, null),
    /**
     * 缅甸语
     */
    MYANMAR("myanmar", "my", null, null),
    /**
     * 苗语
     */
    HMONG("hmong", "hmn", null, null),
    /**
     * 南非科萨语
     */
    XHOSA("xhosa", "xh", null, null),
    /**
     * 南非祖鲁语
     */
    ZULU("zulu", "zu", null, null),
    /**
     * 尼泊尔语
     */
    NEPALI("nepali", "ne", null, null),
    /**
     * 挪威语
     */
    NORWEGIAN("norwegian", "no", null, null),
    /**
     * 旁遮普语
     */
    PUNJABI("punjabi", "pa", null, null),
    /**
     * 葡萄牙语
     */
    PORTUGUESE("portuguese", "pt", null, null),
    /**
     * 普什图语
     */
    PASHTO("pashto", "ps", null, null),
    /**
     * 齐切瓦语
     */
    CHICHEWA("chichewa", "ny", null, null),
    /**
     * 日语
     */
    JAPANESE("japanese", "ja", null, "jp"),
    /**
     * 瑞典语
     */
    SWEDISH("swedish", "sv", null, "swe"),
    /**
     * 萨摩亚语
     */
    SAMOAN("samoan", "sm", null, null),
    /**
     * 塞尔维亚语
     */
    SERBIAN("serbian", "sr", null, null),
    /**
     * 塞索托语
     */
    SESOTHO("sesotho", "st", null, null),
    /**
     * 僧伽罗语
     */
    SINHALA("sinhala", "si", null, null),
    /**
     * 世界语
     */
    ESPERANTO("esperanto", "eo", null, null),
    /**
     * 斯洛伐克语
     */
    SLOVAK("slovak", "sk", null, null),
    /**
     * 斯洛文尼亚语
     */
    SLOVENIAN("slovenian", "sl", null, "slo"),
    /**
     * 斯瓦希里语
     */
    SWAHILI("swahili", "sw", null, null),
    /**
     * 苏格兰盖尔语
     */
    SCOTS_GAELIC("scotsGaelic", "gd", null, null),
    /**
     * 宿务语
     */
    CEBUANO("cebuano", "ceb", null, null),
    /**
     * 索马里语
     */
    SOMALI("somali", "so", null, null),
    /**
     * 塔吉克语
     */
    TAJIK("tajik", "tg", null, null),
    /**
     * 泰卢固语
     */
    TELUGU("telugu", "te", null, null),
    /**
     * 泰米尔语
     */
    TAMIL("tamil", "ta", null, null),
    /**
     * 泰语
     */
    THAI("thai", "th", null, null),
    /**
     * 土耳其语
     */
    TURKISH("turkish", "tr", null, null),
    /**
     * 威尔士语
     */
    WELSH("welsh", "cy", null, null),
    /**
     * 乌尔都语
     */
    URDU("urdu", "ur", null, null),
    /**
     * 乌克兰语
     */
    UKRAINIAN("ukrainian", "uk", null, null),
    /**
     * 乌兹别克语
     */
    UZBEK("uzbek", "uz", null, null),
    /**
     * 西班牙语
     */
    SPANISH("spanish", "es", null, "spa"),
    /**
     * 希伯来语
     */
    HEBREW("hebrew", "iw", null, null),
    /**
     * 希腊语
     */
    GREEK("greek", "el", null, null),
    /**
     * 夏威夷语
     */
    HAWAIIAN("hawaiian", "haw", null, null),
    /**
     * 信德语
     */
    SINDHI("sindhi", "sd", null, null),
    /**
     * 匈牙利语
     */
    HUNGARIAN("hungarian", "hu", null, null),
    /**
     * 修纳语
     */
    SHONA("shona", "sn", null, null),
    /**
     * 亚美尼亚语
     */
    ARMENIAN("armenian", "hy", null, null),
    /**
     * 伊博语
     */
    IGBO("igbo", "ig", null, null),
    /**
     * 意大利语
     */
    ITALIAN("italian", "it", null, null),
    /**
     * 意第绪语
     */
    YIDDISH("yiddish", "yi", null, null),
    /**
     * 印地语
     */
    HINDI("hindi", "hi", null, null),
    /**
     * 印尼巽他语
     */
    SUNDANESE("sundanese", "su", null, null),
    /**
     * 印尼语
     */
    INDONESIAN("indonesian", "id", null, null),
    /**
     * 印尼爪哇语
     */
    JAVANESE("javanese", "jw", null, null),
    /**
     * 约鲁巴语
     */
    YORUBA("yoruba", "yo", null, null),
    /**
     * 越南语
     */
    VIETNAMESE("vietnamese", "vi", null, "vie");

    private static final String RESOURCE_PATH = "i18n.messages.LanguageBundle";

    private static LanguageBundle languageBundle;

    private String langNameKey;
    private String code;
    private String youdaoCode;
    private String baiduCode;

    static {
        languageBundle = new LanguageBundle(RESOURCE_PATH);
    }

     Lang(String langNameKey, String code, String youdaoCode, String baiduCode) {
        this.langNameKey = langNameKey;
        this.code = code;
        this.youdaoCode = youdaoCode;
        this.baiduCode = baiduCode;
    }

    public String getLangNameKey() {
        return langNameKey;
    }

    public String getCode() {
        return code;
    }

    public String getYoudaoCode() {
        return youdaoCode;
    }

    public String getBaiduCode() {
        return baiduCode;
    }

    public String getLocaleLanguage() {

         return languageBundle.getMessage(this.getLangNameKey());
    }

    public static  String getLocaleLanguage(String langNameKey) {

      return languageBundle.getMessage(langNameKey);
    }
    public static Lang getLangByCode(String code){
        Lang[] langs = Lang.values();
        for (int i = 0; i < langs.length; i++) {
            if(langs[i].getCode().equals(code)){
                return langs[i];
            }
        }
        return null;
    }
}
