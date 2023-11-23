package com.example.server.member;

import com.example.server.chat.domain.model.entity.MemberChatRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(unique = true, updatable = false)
    private String account;

    private String password;

    private String nickname;

    private Integer level;

    private Integer exp;

    @Lob
    private String img;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private Set<MemberChatRoom> memberChatRooms = new HashSet<>();

    public void setRoles(List<Authority> roles) {
        this.roles = roles;
        roles.forEach(o -> o.setMember(this));
    }

    public void update(Map<String, String> request) {
        this.nickname = Objects.isNull(request.get("nickname")) ? nickname : request.get("nickname");
        this.img = Objects.isNull(request.get("img")) ? img : request.get("img");
        this.password = Objects.isNull(request.get("password")) ? password : request.get("password");
    }
}
