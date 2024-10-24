package com.launch.template.infrastructure.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = UserDto.TABLE_NAME, schema = "public")
@DynamicUpdate
@EqualsAndHashCode(callSuper = true, of = {})
public class UserDto extends BaseDto<Long> {
    public static final String TABLE_NAME = "`USER`";
    public static final String USERNAME_VALUE = "username";
    public static final String NAME_VALUE = "name";
    public static final String EMAIL_VALUE = "email";
    @Column(name = USERNAME_VALUE, nullable = false, unique = true)
    private String username;
    @Column(name = NAME_VALUE, nullable = false)
    private String name;
    @Column(name = EMAIL_VALUE, nullable = false)
    private String email;

}
