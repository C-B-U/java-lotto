package lotto.lottoManager.service;

import java.text.NumberFormat;

public enum LottoStatistics {

    THIRD(3, 5_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(5, 1_500_000, false),
    FIFTH_AND_BONUS(5, 30_000_000, true),
    SIXTH(6, 2_000_000_000, false);

    private final int matchCount;
    private final int price;
    private final boolean isMatchBonus;

    LottoStatistics(int matchCount, int price, boolean isMatchBonus){
        this.matchCount = matchCount;
        this.price = price;
        this.isMatchBonus = isMatchBonus;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(matchCount).append("개 일치");
        if(isMatchBonus){
            sb.append(", 보너스 볼 일치 ");
        }
        sb.append(" (")
          .append(NumberFormat.getInstance().format(price))
          .append("원)")
          .append(" - ");
        return sb.toString();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
