package lotto.service;

public enum OutputGuide {
    NUMBER_OF_PURCHASE("개를 구매했습니다."),
    RESULT_STATISTICS("당첨 통계\n---");

    private final String content;

    OutputGuide(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}
