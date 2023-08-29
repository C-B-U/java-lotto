package lotto.service;

public enum OutputGuide {
    NUMBER_OF_PURCHASE("개를 구매했습니다."),
    RESULT_STATISTICS("당첨 통계\n---"),

    EQUAL_NUM_GUIDE("개 일치 ("),
    BONUS_NUM_GUIDE("5개 일치, 보너스 볼 일치 ("),
    PRIZE_MONEY_GUIDE("원) - "),
    LOTTO_NUM("개"),

    TOTAL_EARNING_FRONT("총 수익률은 "),
    TOTAL_EARNING_BACK("%입니다.");

    private final String content;

    OutputGuide(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}
