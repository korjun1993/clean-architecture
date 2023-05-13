package account.domain;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public record Money(BigInteger amount) {
    public static Money ZERO = Money.of(0L);

    public boolean isPositiveOrZero() {
        return amount.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isNegative() {
        return amount.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isPositive() {
        return amount.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isGreaterThanOrEqualTo(Money money) {
        return amount.compareTo(money.amount()) >= 0;
    }

    public boolean isGreaterThan(Money money) {
        return amount.compareTo(money.amount()) > 0;
    }

    public Money minus(Money money) {
        return new Money(amount.subtract(money.amount));
    }

    public Money plus(Money money) {
        return new Money(amount.add(money.amount));
    }

    public Money negate() {
        return new Money(amount.negate());
    }

    public static Money of(Long value) {
        return new Money(BigInteger.valueOf(value));
    }

    public static Money add(Money a, Money b) {
        return new Money(a.amount.add(b.amount));
    }

    public static Money subtract(Money a, Money b) {
        return new Money(a.amount.subtract(b.amount));
    }
}
