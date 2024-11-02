package lotto.view;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private final static String ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자로 이루어져 있어야 합니다.";
    private final static String ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자로 이루어져 있어야 합니다.";

    private final static String DELIMITER_COMMA = ",";

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        Validator.validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> parseWinningNumber(String input) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(input.split(DELIMITER_COMMA))
                    .mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE);
        }
        Validator.validateWinningNumber(winningNumbers);

        return winningNumbers.stream().toList();
    }

    public static Integer parseBonusNumber(String input) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE);
        }
        Validator.validateBonusNumber(bonusNumber);

        return bonusNumber;
    }
}
