package account.application;

import account.application.port.in.GetAccountBalanceQuery;
import account.application.port.out.LoadAccountPort;
import account.domain.Account;
import account.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance();
    }
}
