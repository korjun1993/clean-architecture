package account.domain;

import account.domain.Account.AccountId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor
public class Activity {

    private ActivityId id;

    @NonNull
    private final AccountId ownerAccountId;

    @NonNull
    private final AccountId sourceAccountId;

    @NonNull
    private final AccountId targetAccountId;

    @NonNull
    private final LocalDateTime timestamp;

    @NonNull
    private final Money money;

    public Activity(@NonNull AccountId ownerAccountId, @NonNull AccountId sourceAccountId, @NonNull AccountId targetAccountId, @NonNull LocalDateTime timestamp, @NonNull Money money) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    @Value
    public static record ActivityId(Long value) {
    }
}
