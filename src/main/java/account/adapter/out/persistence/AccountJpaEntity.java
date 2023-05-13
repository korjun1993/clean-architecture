package account.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * application 패키지 내에 있는 포트 인터페이스를 통하지 않고는 바깥으레서 호출되지 않는다.
 * 따라서 private-package 접근 수준으로 설정한다.
 * 애플리케이션 계층에서 어댑터 클래스로 향하는 의존성은 있을 수 없다.
 *
 */
@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
class AccountJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
}
