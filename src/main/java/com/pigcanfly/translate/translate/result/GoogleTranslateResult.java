package com.pigcanfly.translate.translate.result;

import java.util.List;

/**
 * @author Tobby Quinn
 * @date 2019/05/16
 */
public class GoogleTranslateResult {

    /**
     * sentences : [{"trans":"happy New Year","orig":"新年快乐","backend":1},{"src_translit":"Xīnnián kuàilè"}]
     * src : zh-CN
     * confidence : 1
     * ld_result : {"srclangs":["zh-CN"],"srclangs_confidences":[1],"extended_srclangs":["zh-CN"]}
     */

    private String src;
    private double confidence;
    private LdResultBean ld_result;
    private List<SentencesBean> sentences;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public LdResultBean getLd_result() {
        return ld_result;
    }

    public void setLd_result(LdResultBean ld_result) {
        this.ld_result = ld_result;
    }

    public List<SentencesBean> getSentences() {
        return sentences;
    }

    public void setSentences(List<SentencesBean> sentences) {
        this.sentences = sentences;
    }

    public static class LdResultBean {
        private List<String> srclangs;
        private List<Double> srclangs_confidences;
        private List<String> extended_srclangs;

        public List<String> getSrclangs() {
            return srclangs;
        }

        public void setSrclangs(List<String> srclangs) {
            this.srclangs = srclangs;
        }

        public List<Double> getSrclangs_confidences() {
            return srclangs_confidences;
        }

        public void setSrclangs_confidences(List<Double> srclangs_confidences) {
            this.srclangs_confidences = srclangs_confidences;
        }

        public List<String> getExtended_srclangs() {
            return extended_srclangs;
        }

        public void setExtended_srclangs(List<String> extended_srclangs) {
            this.extended_srclangs = extended_srclangs;
        }
    }

    public static class SentencesBean {
        /**
         * trans : happy New Year
         * orig : 新年快乐
         * backend : 1
         * src_translit : Xīnnián kuàilè
         */

        private String trans;
        private String orig;
        private int backend;
        private String src_translit;

        public String getTrans() {
            return trans;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }

        public String getOrig() {
            return orig;
        }

        public void setOrig(String orig) {
            this.orig = orig;
        }

        public int getBackend() {
            return backend;
        }

        public void setBackend(int backend) {
            this.backend = backend;
        }

        public String getSrc_translit() {
            return src_translit;
        }

        public void setSrc_translit(String src_translit) {
            this.src_translit = src_translit;
        }
    }
}
