package org.delivery.db.userordermenu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.hibernate.annotations.Cache;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {

    @JoinColumn(nullable = false, name="user_order_id")
    @ManyToOne
    private UserOrderEntity userOrder;  //1:n

    @JoinColumn(nullable = false)
    @ManyToOne
    private StoreMenuEntity storeMenu;  //n:1

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private UserOrderMenuStatus status;


}
