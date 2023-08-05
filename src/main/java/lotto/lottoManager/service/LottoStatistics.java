package lotto.lottoManager.service;

public enum LottoStatistics {

    THIRD(3, "(5,000원)", false),
    FOURTH(4, "(50,000원)", false),
    FIFTH(5, "(1,500,000원)", false),
    FIFTH_AND_BONUS(5, "(30,000,000원)", true),
    SIXTH(6, "(2,000,000,000원)", false);

    private final int matchCount;
    private final String price;
    private final boolean isMatchBonus;

    LottoStatistics(int matchCount, String price, boolean isMatchBonus){
        this.matchCount = matchCount;
        this.price = price;
        this.isMatchBonus = isMatchBonus;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(matchCount).append("개 일치 ");
        if(isMatchBonus){
            sb.append(", 보너스 볼 일치 ");
        }
        sb.append(price).append(" - ");
        return sb.toString();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrice() {
        return price;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
