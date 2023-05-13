package account.application.port.in;

import account.domain.Account.AccountId;
import account.domain.Money;
import common.SelfValidating;
import jakarta.validation.constraints.NotNull;

/**
 * 유효성 검증은 유즈케이스 클래스(SendMoneyUseCase)의 책임이 아니다.
 * 유스케이스는 하나 이상의 어댑터에서 호출되므로, 유효성 검증을 각 어댑터에서 구현한다면, 실수하거나 유효성 검증을 잊어버리게 될 수 있다.
 * <p>
 * 입력 모델(input model)이 이 문제를 다루도록 해보자.
 * '송금하기' 유즈케이스에서 입력 모델은 SendMoneyCommand 이다.
 * 생성자 내에서 입력 유효성을 검증할 것이다.
 */
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    /**
     * final 키워드: 유효성 검사 이후에 다른 값으로 변경될 수 없음
     */

    @NotNull
    private final AccountId sourceAccountId;

    @NotNull
    private final AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
